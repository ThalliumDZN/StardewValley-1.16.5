package com.thallium.sdvm.util.networking;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.util.cca.MoneyComponent;
import com.thallium.sdvm.util.cca.MyComponents;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class CurrencyNetworking
{
    public static Identifier MONEY_SCP = StardewValley.id("money_sc");

    public static void init()
    {
        registerMoneySCP();
    }

    private static void registerMoneySCP()
    {
        ServerPlayNetworking.registerGlobalReceiver(MONEY_SCP, CurrencyNetworking::getMoneySCP);
        ServerPlayNetworking.registerGlobalReceiver(MONEY_SCP, CurrencyNetworking::addMoneySCP);
    }

    private static void addMoneySCP(MinecraftServer minecraftServer, ServerPlayerEntity playerEntity, ServerPlayNetworkHandler serverPlayNetworkHandler, PacketByteBuf byteBuf, PacketSender packetSender)
    {
        MyComponents.MONEY.get(MinecraftClient.getInstance().player).incrementValue();
    }

    private static void getMoneySCP(MinecraftServer minecraftServer, ServerPlayerEntity playerEntity, ServerPlayNetworkHandler serverPlayNetworkHandler, PacketByteBuf byteBuf, PacketSender packetSender)
    {
        MyComponents.MONEY.get(MinecraftClient.getInstance().player).getValue();
        byteBuf.writeInt(MyComponents.MONEY.get(MinecraftClient.getInstance().player).getValue());
    }
}
