package com.thallium.sdvm.util.networking;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.util.cca.MyComponents;
import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class CurrencyNetworking
{
    public static Identifier MONEY_ADD = StardewValley.id("money_add"); // Adds money to a player by a given value


    public static void init() // Could potentially merge this and register packets
    {
        registerPackets();
    }

    private static void registerPackets()
    {
        ServerPlayNetworking.registerGlobalReceiver(MONEY_ADD, CurrencyNetworking::addMoney); // Could make this a lambda instead of a separate method
    }

    /**
     * Adds the specified amount of money to the player
     * @param minecraftServer
     * @param playerEntity
     * @param serverPlayNetworkHandler
     * @param packetByteBuf
     * @param sender
     */
    private static void addMoney(MinecraftServer minecraftServer, ServerPlayerEntity playerEntity, ServerPlayNetworkHandler serverPlayNetworkHandler, PacketByteBuf packetByteBuf, PacketSender sender) {
        int money = packetByteBuf.readInt();
        minecraftServer.execute(() -> {
            MyComponents.MONEY.get(ComponentProvider.fromEntity(playerEntity)).addMoney(money);
        });
    }
}
