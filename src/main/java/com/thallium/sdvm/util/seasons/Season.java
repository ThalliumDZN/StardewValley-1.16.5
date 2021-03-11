package com.thallium.sdvm.util.seasons;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.World;

public class Season
{
    // 720000 = 30 days
    // 672000 = 28 days
    // 24000 = 1 day
    public static int seasonLength = 672000;

    public static SeasonList getCurrentSeason(World world)
    {
        int seasonTime = Math.toIntExact(world.getTimeOfDay()) / seasonLength;
        return SeasonList.values()[seasonTime % 4];
    }

    @Environment(EnvType.CLIENT)
    public static SeasonList getCurrentSeason()
    {
        World world = MinecraftClient.getInstance().world;
        int worldTime = (world != null) ? Math.toIntExact(world.getTimeOfDay()) : 0;
        int seasonTime = (worldTime / seasonLength);
        return SeasonList.values()[seasonTime % 4];
    }

    @Environment(EnvType.CLIENT)
    public static int getSeasonLength()
    {
        return seasonLength;
    }

    @Environment(EnvType.CLIENT)
    public static boolean isSpring()
    {
        return getCurrentSeason().asString().toLowerCase().equals("spring");
    }

    @Environment(EnvType.CLIENT)
    public static boolean isSummer()
    {
        return getCurrentSeason().asString().toLowerCase().equals("summer");
    }

    @Environment(EnvType.CLIENT)
    public static boolean isFall()
    {
        return getCurrentSeason().asString().toLowerCase().equals("fall");
    }

    @Environment(EnvType.CLIENT)
    public static boolean isWinter()
    {
        return getCurrentSeason().asString().toLowerCase().equals("winter");
    }
}
