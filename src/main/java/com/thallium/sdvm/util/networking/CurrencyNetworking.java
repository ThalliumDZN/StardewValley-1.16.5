package com.thallium.sdvm.util.networking;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.util.cca.MyComponents;
import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class CurrencyNetworking
{
    public static Identifier ADD_MONEY = StardewValley.id("add_money"); // Adds money to a player by a given value
    public static Identifier SET_MONEY = StardewValley.id("set_money"); // Sets a players money

    public static void init() // Could potentially merge this and register packets
    {
        registerPackets();
    }

    private static void registerPackets()
    {
        ServerPlayNetworking.registerGlobalReceiver(ADD_MONEY, (minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int money = packetByteBuf.readInt();
            minecraftServer.execute(() -> {
                MyComponents.MONEY.get(ComponentProvider.fromEntity(serverPlayerEntity)).addMoney(money);
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(SET_MONEY, (minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int money = packetByteBuf.readInt();
            minecraftServer.execute(() -> {
                MyComponents.MONEY.get(ComponentProvider.fromEntity(serverPlayerEntity)).setMoney(money);
            });
        });
    }
}
