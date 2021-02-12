package com.thallium.sdvm.entity.mobs.bat;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BatEntityModel extends EntityModel<BatEntity>
{
    private final ModelPart main;
    private final ModelPart head;
    private final ModelPart rightEar;
    private final ModelPart leftEar;
    private final ModelPart body;
    private final ModelPart rightWing;
    private final ModelPart rightWingTip;
    private final ModelPart leftWing;
    private final ModelPart leftWingTip;

    public BatEntityModel()
    {
        textureWidth = 64;
        textureHeight = 64;
        main = new ModelPart(this);
        main.setPivot(0.0F, 24.0F, 0.0F);


        head = new ModelPart(this);
        head.setPivot(0.0F, -24.0F, 0.0F);
        main.addChild(head);
        head.setTextureOffset(0, 0).addCuboid(-7.0F, -7.0F, -3.0F, 10.0F, 7.0F, 6.0F, 0.0F, true);

        rightEar = new ModelPart(this);
        rightEar.setPivot(0.0F, -24.0F, 0.0F);
        main.addChild(rightEar);
        rightEar.setTextureOffset(24, 0).addCuboid(-3.0F, -10.0F, -2.0F, 7.0F, 8.0F, 1.0F, 0.0F, true);

        leftEar = new ModelPart(this);
        leftEar.setPivot(0.0F, -24.0F, 0.0F);
        main.addChild(leftEar);
        leftEar.setTextureOffset(24, 0).addCuboid(-8.0F, -10.0F, -2.0F, 7.0F, 8.0F, 1.0F, 0.0F, false);

        body = new ModelPart(this);
        body.setPivot(0.0F, -24.0F, 0.0F);
        main.addChild(body);
        body.setTextureOffset(0, 16).addCuboid(-7.0F, 0.0F, -3.0F, 10.0F, 16.0F, 6.0F, 0.0F, true);
        body.setTextureOffset(0, 34).addCuboid(-9.0F, 12.0F, 0.0F, 14.0F, 20.0F, 1.0F, 0.0F, true);

        rightWing = new ModelPart(this);
        rightWing.setPivot(0.0F, -24.0F, 0.0F);
        main.addChild(rightWing);
        rightWing.setTextureOffset(42, 0).addCuboid(-2.0F, -3.0F, 1.5F, 14.0F, 20.0F, 1.0F, 0.0F, true);

        rightWingTip = new ModelPart(this);
        rightWingTip.setPivot(12.0F, -23.0F, 1.5F);
        main.addChild(rightWingTip);
        rightWingTip.setTextureOffset(24, 16).addCuboid(0.0F, -3.0F, 0.0F, 8.0F, 16.0F, 1.0F, 0.0F, true);

        leftWing = new ModelPart(this);
        leftWing.setPivot(0.0F, -24.0F, 0.0F);
        main.addChild(leftWing);
        leftWing.setTextureOffset(42, 0).addCuboid(-16.0F, -3.0F, 1.5F, 14.0F, 20.0F, 1.0F, 0.0F, false);

        leftWingTip = new ModelPart(this);
        leftWingTip.setPivot(-12.0F, -23.0F, 1.5F);
        main.addChild(leftWingTip);
        leftWingTip.setTextureOffset(24, 16).addCuboid(-12.0F, -3.0F, 0.0F, 8.0F, 16.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setAngles(BatEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch)
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
