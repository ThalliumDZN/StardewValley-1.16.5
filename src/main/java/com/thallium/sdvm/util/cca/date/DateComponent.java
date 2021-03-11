package com.thallium.sdvm.util.cca.date;

import com.thallium.sdvm.util.cca.MyComponents;
import com.thallium.sdvm.util.networking.date.DateUtils;
import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.level.LevelComponents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import top.theillusivec4.somnus.MixinHooks;
import top.theillusivec4.somnus.api.PlayerSleepEvents;
import top.theillusivec4.somnus.api.WorldSleepEvents;

public class DateComponent implements IDateComponent, AutoSyncedComponent
{
    public int day;
    public PlayerEntity player;
    public WorldProperties level;
    public MinecraftServer server;
    private final int firstDay = 1;

    public DateComponent(WorldProperties level)
    {
        this.level = level;
    }

    @Override
    public int getDay()
    {
        return this.day;
    }

    @Override
    public boolean isLastDay()
    {
        int lastDay = 30;
        return day == lastDay;
    }

    @Override
    public boolean isFirstDay()
    {
        return day == firstDay;
    }

    @Override
    public boolean didAwake()
    {
        return false;
    }

    @Override
    public void newDay(int amount)
    {
        if (isLastDay())
        {
            setDay(firstDay);
        } else{
            this.day += amount;
        }
        LevelComponents.sync(MyComponents.DATE, server);
    }

    @Override
    public void setDay(int amount)
    {
        this.day = amount;
    }

    @Override
    public void readFromNbt(CompoundTag tag)
    {
        this.day = tag.getInt("day");
    }

    @Override
    public void writeToNbt(CompoundTag tag)
    {
        tag.putInt("day", this.day);
    }

    @Override
    public void clientTick()
    {
        LevelComponents.sync(MyComponents.DATE, server);
    }

    @Override
    public void serverTick()
    {
        LevelComponents.sync(MyComponents.DATE, server);
    }
}
