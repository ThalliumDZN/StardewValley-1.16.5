package com.thallium.sdvm.blocks.vendor;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class VendingBlockEntity extends BlockEntity implements Inventory, NamedScreenHandlerFactory, BlockEntityClientSerializable
{
    public static final int REAL_INV_SIZE = 9;
    public static final int FULL_INV_SIZE = REAL_INV_SIZE + 2;
    public static final int PRICE_SLOT = REAL_INV_SIZE;
    public static final int GOOD_SLOT = REAL_INV_SIZE + 1;
    public static BlockEntityType<VendingBlockEntity> TYPE;

    protected ItemStack price = ItemStack.EMPTY;
    protected ItemStack good = ItemStack.EMPTY;
    protected DefaultedList<ItemStack> invStacks = DefaultedList.ofSize(REAL_INV_SIZE, ItemStack.EMPTY);
    protected UUID owner = null;

    public VendingBlockEntity()
    {
        super(TYPE);
    }

    @Override
    public void fromClientTag(CompoundTag tag)
    {
        price = ItemStack.fromTag(tag.getCompound("Price"));
        good = ItemStack.fromTag(tag.getCompound("Good"));
        owner = tag.contains("Owner") ? tag.getUuid("Owner") : null;
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag)
    {
        tag.put("Price", price.toTag(new CompoundTag()));
        tag.put("Good", good.toTag(new CompoundTag()));
        if(owner != null) tag.putUuid("Owner", owner);

        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag)
    {
        super.fromTag(state, tag);
        invStacks.clear();
        Inventories.fromTag(tag, invStacks);
        owner = tag.contains("Owner") ? tag.getUuid("Owner") : null;
        price = tag.contains("Price") ? ItemStack.fromTag(tag.getCompound("Price")) : ItemStack.EMPTY;
        good = tag.contains("Good") ? ItemStack.fromTag(tag.getCompound("Good")) : ItemStack.EMPTY;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag)
    {
        super.toTag(tag);
        Inventories.toTag(tag, invStacks);

        if(owner != null) {
            tag.putUuid("Owner", owner);
        }

        if(!price.isEmpty()) tag.put("Price", price.toTag(new CompoundTag()));
        if(!good.isEmpty()) tag.put("Good", good.toTag(new CompoundTag()));

        return tag;
    }

    @Override
    public int size() {
        return FULL_INV_SIZE;
    }

    @Override
    public boolean isEmpty()
    {
        return invStacks.stream().allMatch(ItemStack::isEmpty) && price.isEmpty() && good.isEmpty();
    }

    @Override
    public ItemStack getStack(int slot)
    {
        if (slot == PRICE_SLOT) return price;
        if (slot == GOOD_SLOT) return good;

        return invStacks.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount)
    {
        if (slot == PRICE_SLOT)
        {
            price.split(amount);
            return ItemStack.EMPTY;
        }
        if (slot == GOOD_SLOT)
        {
            good.split(amount);
            return ItemStack.EMPTY;
        }

        ItemStack result = Inventories.splitStack(invStacks, slot, amount);
        if (!result.isEmpty()) markDirty();

        return result;
    }

    @Override
    public ItemStack removeStack(int slot)
    {
        if(slot == PRICE_SLOT)
        {
            price = ItemStack.EMPTY;
            sync();
            return ItemStack.EMPTY;
        }
        if(slot == GOOD_SLOT)
        {
            good = ItemStack.EMPTY;
            sync();
            return ItemStack.EMPTY;
        }

        return Inventories.removeStack(invStacks, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack)
    {
        if (slot == PRICE_SLOT)
        {
            price = stack;
            sync();
            return;
        }
        if (slot == GOOD_SLOT)
        {
            good = stack;
            sync();
            return;
        }

        invStacks.set(slot, stack);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return owner == null || owner.equals(player.getUuid());
    }

    @Override
    public Text getDisplayName()
    {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        if(!canPlayerUse(player)) return null;
        return new VendingBlockScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public void clear()
    {
        invStacks.clear();
        price = ItemStack.EMPTY;
        good = ItemStack.EMPTY;
        sync();
    }

    public boolean tryExchange(PlayerEntity player) {
        ItemStack held = player.inventory.getMainHandStack();
        if(!held.isEmpty() && held.getItem() == price.getItem() && ItemStack.areTagsEqual(held, price) && held.getCount() >= price.getCount()) {
            // has payment, check whether we have the good

            int goodCountLeft = good.getCount();
            int priceFitLeft = price.getCount();
            for(ItemStack stack : invStacks) {
                if(stack.isEmpty()) {
                    priceFitLeft -= price.getMaxCount();
                }
                else if(stack.getItem() == good.getItem() && ItemStack.areTagsEqual(stack, good)) {
                    goodCountLeft -= stack.getCount();
                    if(goodCountLeft >= 0) {
                        // didn't satisfy, so this slot is now empty
                        priceFitLeft -= price.getMaxCount();
                    }
                }

                if(priceFitLeft <= 0 && goodCountLeft <= 0) break;
            }

            if(priceFitLeft <= 0 && goodCountLeft <= 0) {
                // found enough, now can actually perform the exchange

                ItemStack paid = held.split(price.getCount());

                int toDispense = good.getCount();

                for(int i = 0; i < REAL_INV_SIZE; i++) {
                    ItemStack stack = invStacks.get(i);
                    if(stack.getItem() == good.getItem() && ItemStack.areTagsEqual(stack, good)) {
                        if(stack.getCount() <= toDispense) {
                            invStacks.set(i, ItemStack.EMPTY);
                            toDispense -= stack.getCount();

                            if(toDispense <= 0) break;
                        }
                        else {
                            stack.decrement(toDispense);
                            break;
                        }
                    }
                }

                player.inventory.offerOrDrop(world, good.copy());

                HopperBlockEntity.transfer(null, this, paid, null);

                return true;
            }
        }

        return false;
    }
}
