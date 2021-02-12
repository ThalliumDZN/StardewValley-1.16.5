package com.thallium.sdvm.entity.villagers.clint;

import com.thallium.sdvm.entity.villagers.BaseVillagerEntity;
import com.thallium.sdvm.gui.entity.clint.ClintGuiDescription;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ClintEntity extends BaseVillagerEntity implements NamedScreenHandlerFactory
{
    public ClintEntity(EntityType<? extends PassiveEntity> entityType, World world)
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
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player)
    {
        return new ClintGuiDescription(syncId, inv, player);
    }
}
