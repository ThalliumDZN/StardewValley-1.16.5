package com.thallium.sdvm.entity.villagers.marlon;

import com.thallium.sdvm.gui.entity.marlon.MarlonGuiDescription;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MarlonEntity extends PassiveEntity implements NamedScreenHandlerFactory
{
    public MarlonEntity(EntityType<? extends PassiveEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand)
    {
        player.openHandledScreen(this);
        return ActionResult.SUCCESS;
    }

    @Override
    protected void initGoals()
    {
        super.initGoals();
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        //Possibly the area for creating sdv children
        return null;
    }

    @Override
    public boolean isPushable()
    {
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

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player)
    {
        return new MarlonGuiDescription(syncId, inv);
    }
}
