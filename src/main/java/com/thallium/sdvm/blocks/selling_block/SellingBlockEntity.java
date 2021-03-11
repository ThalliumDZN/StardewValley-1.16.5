package com.thallium.sdvm.blocks.selling_block;

import com.thallium.sdvm.registry.ModEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;

public class SellingBlockEntity extends BlockEntity implements ImplementedInventory
{
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public SellingBlockEntity()
    {
        super(ModEntity.SELLING_BLOCK_ENTITY);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag)
    {
        super.fromTag(state, tag);
        Inventories.fromTag(tag, items);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag)
    {
        Inventories.toTag(tag, items);
        return super.toTag(tag);
    }

    //Implemented inventory methods
    @Override
    public DefaultedList<ItemStack> getItems()
    {
        return items;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public ItemStack getStack(int slot)
    {
        return null;
    }

    @Override
    public ItemStack removeStack(int slot, int count)
    {
        return null;
    }

    @Override
    public ItemStack removeStack(int slot)
    {
        return null;
    }

    @Override
    public void setStack(int slot, ItemStack stack)
    {

    }

    @Override
    public void clear()
    {

    }

    @Override
    public boolean canPlayerUse(PlayerEntity player)
    {
        return true;
    }
}
