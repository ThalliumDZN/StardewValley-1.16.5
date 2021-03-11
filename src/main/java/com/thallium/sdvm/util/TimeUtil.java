package com.thallium.sdvm.util;

import net.minecraft.client.MinecraftClient;

public class TimeUtil
{
    private static MinecraftClient mc;
    private static long ticks = mc.world.getTime();

    public static String day;
    public static String sunset;
    public static String dusk;
    public static String midnight;
    public static String dawn;

    public static void timeConversion(String time)
    {
        //String time = "";

        if (ticks >= 0)
        {
            time = day;
        } else if (ticks >= 12000)
        {
            time = sunset;
        } else if (ticks >= 12610)
        {
            time = dusk;
        } else if (ticks >= 17843)
        {
            time = midnight;
        } else if (ticks >= 23041)
        {
            time = dawn;
        }
    }
}
