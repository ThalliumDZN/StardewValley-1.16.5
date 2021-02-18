package com.thallium.sdvm.util.networking;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.util.cca.MoneyComponent;
import com.thallium.sdvm.util.cca.MyComponents;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.network.packet.s2c.play.CustomPayloadS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class CurrencyPacketUtil
{
    public static final Identifier MONEY_C2S = StardewValley.id("money_csp");
    public static final Identifier MONEY_SCP = StardewValley.id("money_scp");

    public static void sendToServer(CustomPayloadC2SPacket message)
    {
        assert MinecraftClient.getInstance().player != null;
        MinecraftClient.getInstance().player.networkHandler.sendPacket(message);
    }

    public static void sendTo(ServerPlayerEntity player, Identifier channelName, PacketByteBuf buf)
    {

    }

    private static void sendToPlayer(ServerPlayerEntity player, Packet<?> message)
    {
        if (player.networkHandler != null)
        {
            player.networkHandler.sendPacket(message);
        }
    }

    private static void sendToAll(Entity tracked, Packet<?> message)
    {
        if (tracked.world instanceof ServerWorld)
        {
            for (ServerPlayerEntity p : PlayerLookup.tracking(tracked))
            {
                sendToPlayer(p, message);
            }
            if (tracked instanceof ServerPlayerEntity)
            {
                sendToPlayer((ServerPlayerEntity) tracked, message);
            }
        }
    }

    public static void sendCurrencyMessage()
    {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(MyComponents.MONEY.get(MinecraftClient.getInstance().player).getValue());
        sendToServer(new CustomPayloadC2SPacket(MONEY_C2S, buf));
    }

    public static CustomPayloadS2CPacket createCurrencyS2CPacket()
    {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(MyComponents.MONEY.get(MinecraftClient.getInstance().player).getValue());
        return new CustomPayloadS2CPacket(MONEY_SCP, buf);
    }
}
