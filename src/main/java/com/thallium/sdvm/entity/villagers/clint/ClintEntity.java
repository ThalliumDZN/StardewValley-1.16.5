package com.thallium.sdvm.entity.villagers.clint;

import com.thallium.sdvm.entity.villagers.BaseVillagerEntity;
import com.thallium.sdvm.gui.entity.clint.ClintGui;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
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
import top.theillusivec4.somnus.api.PlayerSleepEvents;
import top.theillusivec4.somnus.api.WorldSleepEvents;
import top.theillusivec4.somnus.api.client.SleepRenderEvents;
import top.theillusivec4.somnus.mixin.MixinServerWorld;

public class ClintEntity extends BaseVillagerEntity implements NamedScreenHandlerFactory
{
    public ClintEntity(EntityType<? extends PassiveEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand)
    {
        boolean night = PlayerSleepEvents.canSleepNow(player, getBlockPos());

        if (night)
        {
            return ActionResult.FAIL;
        } else{
            player.openHandledScreen(this);
            return ActionResult.SUCCESS;
        }
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player)
    {
        return new ClintGui(syncId, inv, player);
    }
}
