package com.thallium.sdvm.util.cca;

import com.thallium.sdvm.StardewValley;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class MoneyComponent implements IMoneyComponent, AutoSyncedComponent
{
    public int value;
    public PlayerEntity player;

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
        System.out.println("incremented value correctly");
        MyComponents.MONEY.sync(this.player, (packetByteBuf, serverPlayerEntity) -> writeSyncPacket(packetByteBuf, serverPlayerEntity, true));
    }

    @Override
    public void setValue(int amount)
    {
        this.value = amount;
        System.out.println("set value correctly");
        MyComponents.MONEY.sync(this.player, (packetByteBuf, serverPlayerEntity) -> writeSyncPacket(packetByteBuf, serverPlayerEntity, true));
    }

    @Override
    public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity player)
    {
        this.writeSyncPacket(buf, player, false);
    }

    public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity player, boolean increaseValue)
    {
        buf.writeVarInt(this.value);

        buf.writeBoolean(increaseValue);
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
}
