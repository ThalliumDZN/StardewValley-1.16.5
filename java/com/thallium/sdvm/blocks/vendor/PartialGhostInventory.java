package com.thallium.sdvm.blocks.vendor;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class PartialGhostInventory implements Inventory
{
    private final int divider;
    private DefaultedList<ItemStack> invStacks;

    public PartialGhostInventory(int size, int divider) {
        this.divider = divider;
        invStacks = DefaultedList.ofSize(size, ItemStack.EMPTY);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        invStacks.set(slot, stack);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack result = Inventories.splitStack(invStacks, slot, amount);

        if(isGhost(slot)) return ItemStack.EMPTY;
        return result;
    }

    @Override
    public ItemStack removeStack(int slot) {
        ItemStack result = Inventories.removeStack(invStacks, slot);
        if(isGhost(slot)) return ItemStack.EMPTY;
        return result;
    }

    @Override
    public ItemStack getStack(int slot) {
        return invStacks.get(slot);
    }

    @Override
    public boolean isEmpty() {
        return invStacks.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public int size() {
        return invStacks.size();
    }

    @Override
    public void clear() {
        invStacks.clear();
    }

    @Override
    public void markDirty() {}

    private boolean isGhost(int slot) {
        return slot >= divider;
    }
}
