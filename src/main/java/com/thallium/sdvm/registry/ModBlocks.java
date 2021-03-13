package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.blocks.currency_book.CurrencyBookBlock;
import com.thallium.sdvm.blocks.selling_block.SellingBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks
{
    //Basic Blocks
    public static final Block IRIDIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES,3).requiresTool().strength(25.0f, 2000.0f).sounds(BlockSoundGroup.METAL));

    //Misc Blocks
    public static final Block SELL_BLOCK = new SellingBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.WOOD));

    public static void registerBlocks()
    {
        //Basic Blocks
        Registry.register(Registry.BLOCK, new Identifier(StardewValley.Mod_ID, "iridium_block"), IRIDIUM_BLOCK);

        //Misc Blocks
        Registry.register(Registry.BLOCK, new Identifier("sdvm", "sell_block"), SELL_BLOCK);

        //Non Obtainable
        Registry.register(Registry.BLOCK, new Identifier(StardewValley.Mod_ID, "currency_block"), CurrencyBookBlock.INSTANCE);
    }
}
