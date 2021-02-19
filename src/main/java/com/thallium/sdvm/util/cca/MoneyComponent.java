package com.thallium.sdvm.util.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;

public class MoneyComponent implements IMoneyComponent, AutoSyncedComponent {
    public int value;
    public PlayerEntity player;
    public World world;

    public MoneyComponent(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public void writeToNbt(CompoundTag tag) {
        tag.putInt("value", this.value);
    }

    @Override
    public void readFromNbt(CompoundTag tag) {
        this.value = tag.getInt("value");
    }

    @Override
    public int getMoney() {
        return this.value;
    }

    @Override
    public void setMoney(int amount) {
        this.value = amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public boolean isNegativeMoney() {
        return value < 0;
    }

    @Override
    public void resetMoney() {
        value = 0;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void purchase(ItemStack item, int cost) {
        if (value >= cost) {
            subtractMoney(cost);
            player.giveItemStack(item);
        }
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void addMoney(int amount) {
        this.value += amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void subtractMoney(int amount) {
        value = Math.max(0, value-amount); // To ensure money doesn't go below 0, up to other methods to make sure there is enough money for the operation
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void multiplyMoney(int amount) {
        this.value *= amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void divideMoney(int amount) {
        this.value /= amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }
}
