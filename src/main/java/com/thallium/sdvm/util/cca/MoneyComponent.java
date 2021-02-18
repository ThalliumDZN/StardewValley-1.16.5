package com.thallium.sdvm.util.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;

public class MoneyComponent implements IMoneyComponent, AutoSyncedComponent
{
    public int value;
    public PlayerEntity player;
    public World world;

    public MoneyComponent(PlayerEntity player)
    {
        this.player = player;
    }

    @Override
    public void writeToNbt(CompoundTag tag)
    {
        tag.putInt("value", this.value);
    }

    @Override
    public void readFromNbt(CompoundTag tag)
    {
        this.value = tag.getInt("value");
    }

    @Override
    public int getMoney()
    {
        return this.value;
    }

    @Override
    public void setMoney(int amount)
    {
        this.value = amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void addMoney(int amount) {
        value += amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }
}
