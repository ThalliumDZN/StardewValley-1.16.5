package com.thallium.sdvm.blocks.currency_book;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.entity.model.BookModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.Objects;

public class CurrencyBookBlockEntityRenderer extends BlockEntityRenderer<CurrencyBookBlockEntity>
{
    public static final SpriteIdentifier BOOK_TEXTURE;
    private final BookModel book = new BookModel();
    private static final ItemStack item = new ItemStack(Items.BOOK, 1);

    public CurrencyBookBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher)
    {
        super(dispatcher);
    }

    @Override
    public void render(CurrencyBookBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        matrices.push();
        matrices.translate(0.5D, 2, 0.5D);
        float g = (float)entity.ticks + tickDelta;
        matrices.translate(0.0D, 0.1F + MathHelper.sin(g * 0.1F) * 0.01F, 0.0D);
        VertexConsumer vertex = BOOK_TEXTURE.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid);
        this.book.setPageAngles(1.0F, 1.0F, 1.0F, 1.0F);
        this.book.method_24184(matrices, vertex, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
        MinecraftClient.getInstance().getItemRenderer().renderItem(item, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers);

        //Mandatory call after openGL calls
        matrices.pop();
    }

    static {
        BOOK_TEXTURE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("entity/enchanting_table_book"));
    }
}
