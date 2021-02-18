package com.thallium.sdvm.blocks.vendor;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import org.jetbrains.annotations.Nullable;

public class VendingBlockScreenHandler extends ScreenHandler
{
    public static ScreenHandlerType<VendingBlockScreenHandler> TYPE;

    private final Inventory inventory;

    public VendingBlockScreenHandler(int syncID, PlayerInventory playerInventory)
    {
        this(syncID, playerInventory, new PartialGhostInventory(VendingBlockEntity.FULL_INV_SIZE, VendingBlockEntity.REAL_INV_SIZE));
    }

    public VendingBlockScreenHandler(int syncID, PlayerInventory playerInventory, Inventory inventory) {
        super(TYPE, syncID);

        this.inventory = inventory;

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                addSlot(new Slot(inventory, x + y * 3, 62 + x * 18, 17 + y * 18));
            }
        }

        addSlot(new Slot(inventory, 9, 26, 35));
        addSlot(new Slot(inventory, 10, 134, 35));

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 9; x++) {
                addSlot(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for(int x = 0; x < 9; x++) {
            addSlot(new Slot(playerInventory, x, 8 + x * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player)
    {
        return inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack onSlotClick(int slotIdx, int actionData, SlotActionType actionType, PlayerEntity player)
    {
        Slot slot = slotIdx < 0 ? null : this.slots.get(slotIdx);
        if(slotIdx < VendingBlockEntity.REAL_INV_SIZE || slot.inventory != inventory) {
            return super.onSlotClick(slotIdx, actionData, actionType, player);
        }

        ItemStack playerStack = player.inventory.getCursorStack();

        if(actionType != SlotActionType.PICKUP) return playerStack;

        if(playerStack.isEmpty()) {
            if(actionData == 1) {
                ItemStack stack = slot.getStack();
                if(!stack.isEmpty()) {
                    stack.setCount(stack.getCount() / 2);
                }

                return stack;
            }
            else {
                slot.setStack(ItemStack.EMPTY);

                return ItemStack.EMPTY;
            }
        }
        else {
            ItemStack existing = slot.getStack();
            if(existing.isEmpty()) {
                ItemStack newStack = playerStack.copy();
                if(actionData == 1) newStack.setCount(1);
                slot.setStack(newStack);

                return newStack;
            }
            else {
                if(ScreenHandler.canStacksCombine(existing, playerStack)) {
                    int newCount = Math.min(
                            existing.getCount() + (actionData == 1 ? 1 : playerStack.getCount()),
                            existing.getMaxCount()
                    );
                    existing.setCount(newCount);
                    if(inventory instanceof VendingBlockEntity) ((VendingBlockEntity) inventory).sync();

                    return existing;
                }
                else {
                    if(actionData != 1) {
                        ItemStack newStack = playerStack.copy();
                        slot.setStack(newStack);

                        return newStack;
                    }
                    return existing;
                }
            }
        }
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index)
    {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null) {
            ItemStack itemStack2 = slot.getStack();
            if(!itemStack2.isEmpty()) {
                itemStack = itemStack2.copy();
                if (index < VendingBlockEntity.REAL_INV_SIZE) {
                    if (!this.insertItem(itemStack2, VendingBlockEntity.FULL_INV_SIZE, this.slots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                } else if(index < VendingBlockEntity.FULL_INV_SIZE) {
                    slot.setStack(ItemStack.EMPTY);
                    return ItemStack.EMPTY;
                } else if (!this.insertItem(itemStack2, 0, VendingBlockEntity.REAL_INV_SIZE, false)) {
                    return ItemStack.EMPTY;
                }

                if (itemStack2.isEmpty()) {
                    slot.setStack(ItemStack.EMPTY);
                } else {
                    slot.markDirty();
                }
            }
        }

        return itemStack;
    }
}
