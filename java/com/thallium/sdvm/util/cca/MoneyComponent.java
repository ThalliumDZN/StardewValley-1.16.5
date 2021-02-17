package com.thallium.sdvm.util.cca;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.registry.ModNetworking;
import com.thallium.sdvm.util.networking.CurrencyPacketUtil;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import io.netty.buffer.ByteBuf;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoneyComponent implements IMoneyComponent, AutoSyncedComponent
{
    public int value;
    public PlayerEntity player;
    public ServerPlayerEntity serverPlayer;
    public World world;

    public MoneyComponent(PlayerEntity player)
    {
        this.player = player;
    }

    @Override
    public void writeToNbt(CompoundTag tag)
    {
        tag.putInt("value", this.value);
    }

    @Override
    public void readFromNbt(CompoundTag tag)
    {
        this.value = tag.getInt("value");
    }

    @Override
    public int getValue()
    {
        return this.value;
    }

    @Override
    public void incrementValue()
    {
        this.value++;
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeVarInt(value);

        System.out.println("incremented value correctly");
        //MyComponents.MONEY.sync(MinecraftClient.getInstance().player);
    }

    @Override
    public void setValue(int amount)
    {
        this.value = amount;
        System.out.println("set value correctly");
    }

    /*
    @Override
    public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity player)
    {
        this.writeSyncPacket(buf, player);
        buf.writeVarInt(this.value);
    }

    @Override
    public void applySyncPacket(PacketByteBuf buf)
    {
        this.value = buf.readVarInt();

        if (buf.readBoolean())
        {
            this.value++;
        }
    }

    @Override
    public boolean shouldSyncWith(ServerPlayerEntity player)
    {
        return player == this.player;
    }
     */
}
