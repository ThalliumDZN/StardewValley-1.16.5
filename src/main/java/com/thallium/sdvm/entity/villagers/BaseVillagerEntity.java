package com.thallium.sdvm.entity.villagers;

import com.thallium.sdvm.util.npc.VillagerUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class BaseVillagerEntity extends PassiveEntity implements VillagerUtils
{
    public boolean married;

    protected BaseVillagerEntity(EntityType<? extends PassiveEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return null;
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

    @Override
    public boolean isMarried()
    {
        return married;
    }
}
