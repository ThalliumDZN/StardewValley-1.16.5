package com.thallium.sdvm.util.networking;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;

public class CurrencyUtils {

    /**
     * Adds money to the player that sends the packet
     * Client to server
     * @param i Money to be added, just put as one if you want to increment
     */
    public static void addMoney(int i) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(CurrencyNetworking.ADD_MONEY, buf);
    }

    /**
     * Sets the players money to the given value
     * Client to server
     * @param i New amount of money
     */
    public static void setMoney(int i) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(CurrencyNetworking.SET_MONEY, buf);
    }
}
