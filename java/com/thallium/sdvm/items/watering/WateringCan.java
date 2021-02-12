package com.thallium.sdvm.items.watering;

import net.minecraft.item.Item;

public class WateringCan extends WateringCanBase
{
    public WateringCan(Settings settings)
    {
        super(settings);
    }

    @Override
    protected boolean canExtinguishFire() {
        return false;
    }

    @Override
    protected boolean canMoisturizeFarmland() {
        return false;
    }

    @Override
    protected boolean canSpawnFlowers() {
        return false;
    }

    @Override
    protected boolean canSpreadGrass() {
        return false;
    }

    @Override
    protected boolean canSpreadMycelium() {
        return false;
    }

    @Override
    protected boolean canGrowCrops() {
        return false;
    }

    @Override
    protected boolean canGrowSaplings() {
        return false;
    }

    @Override
    protected int getDelayModifier() {
        return 0;
    }

    @Override
    protected boolean consumeWaterSource() {
        return false;
    }

    @Override
    protected int getRange() {
        return 0;
    }

    @Override
    protected int getFlowerChance() {
        return 0;
    }

    @Override
    protected boolean isDispensable() {
        return false;
    }
}
