package com.thallium.sdvm.entity.villagers.clint;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ClintEntityRenderer extends MobEntityRenderer<ClintEntity, ClintEntityModel>
{
    public ClintEntityRenderer(EntityRenderDispatcher entityRenderDispatcher)
    {
        super(entityRenderDispatcher, new ClintEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(ClintEntity entity)
    {
        return new Identifier("sdvm", "textures/entity/clint/clint.png");
    }
}
