package com.thallium.sdvm.items.rings;

import com.mojang.blaze3d.platform.GlStateManager;
import com.thallium.sdvm.items.rings.util.RingMaterial;
import com.thallium.sdvm.registry.ModItems;
import com.thallium.sdvm.registry.ModTrinkets;
import dev.emi.trinkets.api.Trinket;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagnetRing extends RingMaterial
{
    public MagnetRing(String name, String tooltip)
    {
        super(name,tooltip);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        super.tick(player, stack);
        if(!player.world.isClient && !player.isSneaking()) {
            int range = 4;
            BlockPos pos = player.getBlockPos();
            List<ItemEntity> entities = player.world.getEntitiesByClass(ItemEntity.class, new Box(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range), null);
            for(ItemEntity item : entities) {
                if(item.isAlive() && !item.cannotPickup()) {
                    item.onPlayerCollision(player);
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(new TranslatableText("item.sdvm.magnet_ring.tooltip"));
    }
}
