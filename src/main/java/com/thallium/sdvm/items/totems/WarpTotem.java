package com.thallium.sdvm.items.totems;

import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WarpTotem extends ConsumableTotem
{
    public WarpTotem(Settings settings)
    {
        super();
    }

    @Override
    public ItemStack onDoneUsing(ItemStack stack, World world, ServerPlayerEntity user)
    {
        BlockPos spawn = user.getSpawnPointPosition();

        if (spawn != null && user.getSpawnPointDimension()
                .getValue()
                .equals(world.getRegistryKey()
                        .getValue())) {
            stack.decrement(1);
            user.teleport(spawn.getX(), spawn.getY(), spawn.getZ());
        }

        return stack;
    }
}
