package com.thallium.sdvm.entity.villagers.marlon;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MarlonEntityRenderer extends MobEntityRenderer<MarlonEntity, MarlonEntityModel>
{
    public MarlonEntityRenderer(EntityRenderDispatcher entityRenderDispatcher)
    {
        super(entityRenderDispatcher, new MarlonEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(MarlonEntity entity)
    {
        return new Identifier("sdvm", "textures/entity/marlon/marlon.png");
    }
}
