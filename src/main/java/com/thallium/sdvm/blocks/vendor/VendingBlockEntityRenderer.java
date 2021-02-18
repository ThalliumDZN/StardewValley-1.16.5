package com.thallium.sdvm.blocks.vendor;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;

public class VendingBlockEntityRenderer extends BlockEntityRenderer<VendingBlockEntity>
{
    public VendingBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(VendingBlockEntity be, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();

        matrices.translate(0.5, 0.25, 0.5);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((be.getWorld().getTime() + tickDelta) * 4));
        MinecraftClient.getInstance().getItemRenderer().renderItem(be.good, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers);

        matrices.push();
        matrices.translate(0.05, 0.15, 0.15);
        matrices.scale(0.025f, -0.025f, 0.025f);
        MinecraftClient.getInstance().textRenderer.draw(matrices, be.good.getCount() + "", 0, 0, 0xffffffff);
        matrices.pop();

        matrices.push();
        matrices.translate(-0.05, 0.15, -0.15);
        matrices.scale(0.025f, -0.025f, 0.025f);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180));
        MinecraftClient.getInstance().textRenderer.draw(matrices, be.good.getCount() + "", 0, 0, 0xffffffff);
        matrices.pop();

        matrices.pop();

        matrices.push();

        matrices.translate(0.5, 1.25, 0.5);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((be.getWorld().getTime() + tickDelta) * 4));
        MinecraftClient.getInstance().getItemRenderer().renderItem(be.price, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers);

        matrices.push();
        matrices.translate(0.05, 0.15, 0.15);
        matrices.scale(0.025f, -0.025f, 0.025f);
        MinecraftClient.getInstance().textRenderer.draw(matrices, be.price.getCount() + "", 0, 0, 0xffffffff);
        matrices.pop();

        matrices.push();
        matrices.translate(-0.05, 0.15, -0.15);
        matrices.scale(0.025f, -0.025f, 0.025f);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180));
        MinecraftClient.getInstance().textRenderer.draw(matrices, be.price.getCount() + "", 0, 0, 0xffffffff);
        matrices.pop();

        matrices.pop();
    }
}
