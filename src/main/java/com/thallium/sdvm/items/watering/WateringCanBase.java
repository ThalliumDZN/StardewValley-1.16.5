package com.thallium.sdvm.items.watering;

import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class WateringCanBase extends Item
{
    public static final int MILLI_BUCKETS_PER_USE = 10;

    public WateringCanBase(Settings settings)
    {
        super(settings);
    }

    protected abstract boolean canExtinguishFire();

    protected abstract boolean canMoisturizeFarmland();

    protected abstract boolean canSpawnFlowers();

    protected abstract boolean canSpreadGrass();

    protected abstract boolean canSpreadMycelium();

    protected abstract boolean canGrowCrops();

    protected abstract boolean canGrowSaplings();

    protected abstract int getDelayModifier();

    protected abstract boolean consumeWaterSource();

    protected abstract int getRange();

    protected abstract int getFlowerChance();

    protected abstract boolean isDispensable();

    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();

        useOnFarmland(world, blockPos);

        return ActionResult.SUCCESS;
    }

    public static void useOnFarmland(World world, BlockPos pos)
    {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof FarmlandBlock)
        {
            world.setBlockState(pos, (BlockState)blockState.with(FarmlandBlock.MOISTURE, 7));
        }
    }

    @Override
    public boolean isEnchantable(ItemStack stack)
    {
        return false;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner)
    {
        return false;
    }

    @Override
    public int getMaxUseTime(ItemStack stack)
    {
        return 10;
    }

    @Override
    public boolean isDamageable()
    {
        return true;
    }
}
