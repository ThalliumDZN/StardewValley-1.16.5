package com.thallium.sdvm.items.watering;

import net.minecraft.world.World;

public interface IWateringCanParticle
{
    IWateringCanParticle NO_OP = (world, x, y, z, range) ->
    {
        //
    };

    void spawnParticles(
            World world,
            double x,
            double y,
            double z,
            int range
    );
}
