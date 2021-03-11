package com.thallium.sdvm.entity.villagers.marlon;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class MarlonEntityModel extends EntityModel<MarlonEntity>
{
    private final ModelPart Head;
    private final ModelPart Body;
    private final ModelPart RightArm;
    private final ModelPart LeftArm;
    private final ModelPart RightLeg;
    private final ModelPart LeftLeg;

    public MarlonEntityModel()
    {
        textureWidth = 128;
        textureHeight = 128;
        Head = new ModelPart(this);
        Head.setPivot(0.0F, 0.0F, 0.0F);
        setRotationAngle(Head, 0.0F, 0.0F, 0.0F);
        Head.setTextureOffset(0, 16).addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        Head.setTextureOffset(0, 0).addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

        Body = new ModelPart(this);
        Body.setPivot(0.0F, 0.0F, 0.0F);
        Body.setTextureOffset(28, 28).addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);
        Body.setTextureOffset(0, 32).addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        RightArm = new ModelPart(this);
        RightArm.setPivot(-5.0F, 2.0F, 0.0F);
        setRotationAngle(RightArm, 0.0F, 0.0F, 0.0F);
        RightArm.setTextureOffset(56, 0).addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        RightArm.setTextureOffset(52, 28).addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        LeftArm = new ModelPart(this);
        LeftArm.setPivot(5.0F, 2.0F, 0.0F);
        setRotationAngle(LeftArm, 0.0F, 0.0F, 0.0F);
        LeftArm.setTextureOffset(52, 52).addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        LeftArm.setTextureOffset(0, 48).addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        RightLeg = new ModelPart(this);
        RightLeg.setPivot(-1.9F, 12.0F, 0.0F);
        setRotationAngle(RightLeg, 0.0F, 0.0F, 0.0F);
        RightLeg.setTextureOffset(44, 12).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        RightLeg.setTextureOffset(36, 44).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        LeftLeg = new ModelPart(this);
        LeftLeg.setPivot(1.9F, 12.0F, 0.0F);
        setRotationAngle(LeftLeg, 0.0F, 0.0F, 0.0F);
        LeftLeg.setTextureOffset(20, 44).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        LeftLeg.setTextureOffset(32, 0).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
    }

    @Override
    public void setAngles(MarlonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch)
    {

    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        Head.render(matrixStack, buffer, packedLight, packedOverlay);
        Body.render(matrixStack, buffer, packedLight, packedOverlay);
        RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
        RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelPart main, float x, float y, float z)
    {
        main.pitch = x;
        main.yaw = y;
        main.roll = z;
    }
}
