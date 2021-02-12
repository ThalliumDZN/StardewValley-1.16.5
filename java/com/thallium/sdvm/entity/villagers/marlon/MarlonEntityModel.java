package com.thallium.sdvm.entity.villagers.marlon;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class MarlonEntityModel extends EntityModel<MarlonEntity>
{
    private final ModelPart main;
    private final ModelPart head;
    private final ModelPart arms;
    private final ModelPart body;
    private final ModelPart legs;

    public MarlonEntityModel()
    {
        textureWidth = 64;
        textureHeight = 64;
        main = new ModelPart(this);
        main.setPivot(0.0F, 24.0F, -1.0F);


        head = new ModelPart(this);
        head.setPivot(0.0F, -3.0F, 0.0F);
        main.addChild(head);
        head.setTextureOffset(0, 0).addCuboid(-4.0F, -29.0F, -3.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        arms = new ModelPart(this);
        arms.setPivot(2.0F, -12.0F, 1.0F);
        main.addChild(arms);
        arms.setTextureOffset(24, 24).addCuboid(-10.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        arms.setTextureOffset(0, 32).addCuboid(2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        body = new ModelPart(this);
        body.setPivot(0.0F, 0.0F, 0.0F);
        main.addChild(body);
        body.setTextureOffset(0, 16).addCuboid(-4.0F, -24.0F, -1.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        legs = new ModelPart(this);
        legs.setPivot(3.0F, 0.0F, 1.0F);
        main.addChild(legs);
        legs.setTextureOffset(36, 36).addCuboid(-7.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        legs.setTextureOffset(32, 0).addCuboid(-3.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setAngles(MarlonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch)
    {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha)
    {
        main.render(matrices, vertices, light, overlay);
    }

    public void setRotationAngle(ModelPart main, float x, float y, float z)
    {
        main.pitch = x;
        main.yaw = y;
        main.roll = z;
    }
}
