package com.thallium.sdvm.util.rings;

import com.mojang.blaze3d.platform.GlStateManager;
import com.thallium.sdvm.registry.ModTrinkets;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class RingMaterial extends TrinketItem
{
    private String ringName;
    private String tooltip;

    public RingMaterial(String name, String tooltip) {
        super(new Settings().group(ItemGroup.TOOLS).maxCount(1));
        this.ringName = name;
        this.tooltip = tooltip;
    }

    @Override
    public boolean canWearInSlot(String group, String slot) {
        return group.equals(SlotGroups.HAND) && slot.equals(Slots.RING);
    }

    @Override
    public void render(String slot, MatrixStack matrixStack, VertexConsumerProvider vertexConsumer, int light, PlayerEntityModel<AbstractClientPlayerEntity> model, AbstractClientPlayerEntity player, float headYaw, float headPitch)
    {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = new ItemStack(ModTrinkets.rubyRing);
        Trinket.translateToLeftArm(matrixStack, model, player, headYaw, headPitch);
        GlStateManager.scalef(0.2F, -0.2F, 0.2F);
        itemRenderer.renderItem(stack, ModelTransformation.Mode.FIXED, light, 1, matrixStack, vertexConsumer);
    }
}
