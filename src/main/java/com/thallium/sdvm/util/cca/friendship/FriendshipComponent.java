package com.thallium.sdvm.util.cca.friendship;

import net.minecraft.nbt.CompoundTag;

public class FriendshipComponent implements IFriendshipComponent
{
    public int amount;
    private final int maxAmount = 100;

    @Override
    public int getAmount()
    {
        return 0;
    }

    @Override
    public boolean isMaxAmount()
    {
        return false;
    }

    @Override
    public void addAmount()
    {

    }

    @Override
    public void subtractAmount()
    {

    }

    @Override
    public void readFromNbt(CompoundTag compoundTag)
    {

    }

    @Override
    public void writeToNbt(CompoundTag compoundTag)
    {

    }

    @Override
    public boolean equals(Object o)
    {
        return false;
    }
}
