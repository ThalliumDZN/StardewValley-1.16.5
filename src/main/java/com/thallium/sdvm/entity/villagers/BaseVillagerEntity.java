package com.thallium.sdvm.entity.villagers;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class BaseVillagerEntity extends PassiveEntity
{


    protected BaseVillagerEntity(EntityType<? extends PassiveEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        //Possibly the area for creating sdv children
        return null;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player)
    {
        return false;
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier)
    {
        return false;
    }

    @Override
    public boolean isInvulnerable()
    {
        return true;
    }


}
