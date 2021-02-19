package com.thallium.sdvm.util.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;

public class MoneyComponent implements IMoneyComponent, AutoSyncedComponent
{
    public int value;
    public PlayerEntity player;
    public World world;
    PlayerInventory playerInventory;

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
    public boolean isNegativeMoney()
    {
        return value < 0;
    }


    @Override
    public void setMoney(int amount)
    {
        this.value = amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void resetMoney()
    {
        value = 0;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void purchase(ItemStack item, int cost, int amount)
    {
        amount = this.value;

        if (amount < cost)
        {
            MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
        }
        else
            {
                amount -= cost;
                player.giveItemStack(item);
                playerInventory.insertStack(item);
                MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
            }
    }

    @Override
    public void addMoney(int amount)
    {
        this.value += amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void subtractMoney(int amount)
    {
        this.value -= amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));

        if (this.value < amount)
        {
            MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
        }else
        {
            this.value -= amount;
            MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
        }
    }

    @Override
    public void multiplyMoney(int amount)
    {
        this.value *= amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void divideMoney(int amount)
    {
        this.value /= amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }
}
