package com.thallium.sdvm.util.networking.date;

import com.thallium.sdvm.util.networking.money.CurrencyNetworking;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;

public class DateUtils
{
    /**
     * Author: AshIndigo
     * Packet utilities for controlling the date
     * Client to server
     * @param i = day
     */

    public static void newDay(int i)
    {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(DateNetworking.NEW_DAY, buf);
    }

    public static void setDay(int i)
    {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(i);
        ClientPlayNetworking.send(DateNetworking.SET_DAY, buf);
    }
}
