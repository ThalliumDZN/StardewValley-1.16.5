package com.thallium.sdvm.util.networking.money;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.gui.widgets.WBuyButton;
import com.thallium.sdvm.util.cca.MyComponents;
import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CurrencyNetworking
{
    /**
     * Author: AshIndigo
     * Client to server
     */
    public static Identifier ADD_MONEY = StardewValley.id("add_money"); // Adds money to a player by a given value
    public static Identifier SUBTRACT_MONEY = StardewValley.id("subtract_money"); // Subtracts a players money
    public static Identifier MULTIPLY_MONEY = StardewValley.id("multiply_money"); // Multiplies a players money
    public static Identifier DIVIDE_MONEY = StardewValley.id("divide_money"); // Divides a players money
    public static Identifier RESET_MONEY = StardewValley.id("reset_money"); // Resets a players money
    public static Identifier SET_MONEY = StardewValley.id("set_money"); // Sets a players money
    public static Identifier PURCHASE = StardewValley.id("purchase"); // Purchases and gives item to player

    public static Identifier VERIFY_PURCHASE = StardewValley.id("verify_purchase"); // Verify if a player has purchased something
    public static Identifier VERIFY_MONEY = StardewValley.id("verify_money"); //Verifies that a players currency is correct

    public static void init() // Could potentially merge this and register packets
    {
        registerPackets();
    }

    private static void registerPackets() {
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

        ServerPlayNetworking.registerGlobalReceiver(SUBTRACT_MONEY, (minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int money = packetByteBuf.readInt();
            minecraftServer.execute(() -> {
                MyComponents.MONEY.get(ComponentProvider.fromEntity(serverPlayerEntity)).subtractMoney(money);
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(MULTIPLY_MONEY, (minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int money = packetByteBuf.readInt();
            minecraftServer.execute(() -> {
                MyComponents.MONEY.get(ComponentProvider.fromEntity(serverPlayerEntity)).multiplyMoney(money);
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(DIVIDE_MONEY, (minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int money = packetByteBuf.readInt();
            minecraftServer.execute(() -> {
                MyComponents.MONEY.get(ComponentProvider.fromEntity(serverPlayerEntity)).divideMoney(money);
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(RESET_MONEY, (minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int money = packetByteBuf.readInt();
            minecraftServer.execute(() -> {
                MyComponents.MONEY.get(ComponentProvider.fromEntity(serverPlayerEntity)).resetMoney();
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(VERIFY_MONEY, (minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int money = packetByteBuf.readInt();
            minecraftServer.execute(() ->
            {
                MyComponents.MONEY.get(ComponentProvider.fromEntity(serverPlayerEntity)).getMoney();
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(PURCHASE, (minecraftServer, serverPlayerEntity, serverPlayNetworkHandler, packetByteBuf, packetSender) -> {
            int cost = packetByteBuf.readInt();
            ItemStack item = packetByteBuf.readItemStack();
            minecraftServer.execute(() ->
            {
                MyComponents.MONEY.get(ComponentProvider.fromEntity(serverPlayerEntity)).purchase(item, cost);
            });
        });
    }
}
