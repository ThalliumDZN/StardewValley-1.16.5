package com.thallium.sdvm.util.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
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
    public void setValue(int amount)
    {
        this.value = amount;
        System.out.println("set value correctly");
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
    }

    @Override
    public void addMoney(int amount) {
        value += amount;
        MyComponents.MONEY.sync(ComponentProvider.fromEntity(player));
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
