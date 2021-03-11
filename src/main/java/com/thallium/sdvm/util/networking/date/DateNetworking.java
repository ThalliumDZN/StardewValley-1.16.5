package com.thallium.sdvm.util.networking.date;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.util.cca.MyComponents;
import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class DateNetworking
{
    /**
     * Author: AshIndigo
     * Client to server
     */

    public static Identifier NEW_DAY = StardewValley.id("new_day"); // Increments 1 day
    public static Identifier SET_DAY = StardewValley.id("set_day"); // Sets the day to 0
    private static World world;

    public static void init()
    {
        registerPackets();
    }

    private static void registerPackets()
    {
        ServerPlayNetworking.registerGlobalReceiver(NEW_DAY, ((minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int day = packetByteBuf.readInt();
            minecraftServer.execute(() ->
            {
                MyComponents.DATE.get(ComponentProvider.fromWorld(world)).newDay(day);
            });
        }));

        ServerPlayNetworking.registerGlobalReceiver(SET_DAY, ((minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int day = packetByteBuf.readInt();
            minecraftServer.execute(() ->
            {
                MyComponents.DATE.get(ComponentProvider.fromWorld(world)).setDay(day);
            });
        }));
    }
}
