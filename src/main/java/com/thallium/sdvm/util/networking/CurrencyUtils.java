package com.thallium.sdvm.util.networking;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;

public class CurrencyUtils {

    /**
     * Packet utilities for controlling currency
     * Client to server
     * @param i = amount of money
     */
    public static void addMoney(int i) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(CurrencyNetworking.ADD_MONEY, buf);
    }

    public static void subtractMoney(int i) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(CurrencyNetworking.SUBTRACT_MONEY, buf);
    }

    public static void multiplyMoney(int i) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(CurrencyNetworking.MULTIPLY_MONEY, buf);
    }

    public static void divideMoney(int i) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(CurrencyNetworking.DIVIDE_MONEY, buf);
    }

    public static void resetMoney(int i) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(CurrencyNetworking.RESET_MONEY, buf);
    }

    public static void setMoney(int i) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(CurrencyNetworking.SET_MONEY, buf);
    }

    public static void purchase(ItemStack item, int cost) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(cost);
        buf.writeItemStack(item);
        ClientPlayNetworking.send(CurrencyNetworking.PURCHASE, buf);
    }


}
