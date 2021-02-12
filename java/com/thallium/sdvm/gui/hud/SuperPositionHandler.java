package com.thallium.sdvm.gui.hud;

import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

public class SuperPositionHandler
{
    public static RegistryKey<World> getNetherKey()
    {
        return World.NETHER;
    }

    public static RegistryKey<World> getEndKey()
    {
        return World.END;
    }
}
