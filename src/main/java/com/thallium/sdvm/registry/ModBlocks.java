package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.blocks.CustomFarmlandBlock;
import com.thallium.sdvm.blocks.shipping_block.ShippingBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks
{
    //Basic Blocks
    public static final Block IRIDIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES,3).requiresTool().strength(25.0f, 2000.0f).sounds(BlockSoundGroup.METAL));

    //Misc Blocks
    public static final Block SELL_BLOCK = new ShippingBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.WOOD));

    //Farmland
    public static final Block FERTILIZED_FARMLAND = new CustomFarmlandBlock(FabricBlockSettings.of(Material.SOIL).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.GRAVEL));

    public static void registerBlocks()
    {
        //Basic Blocks
        Registry.register(Registry.BLOCK, new Identifier(StardewValley.Mod_ID, "iridium_block"), IRIDIUM_BLOCK);

        //Misc Blocks
        Registry.register(Registry.BLOCK, new Identifier("sdvm", "sell_block"), SELL_BLOCK);

        //Farmland
        Registry.register(Registry.BLOCK, new Identifier("sdvm", "custom_farmland_block"), FERTILIZED_FARMLAND);
    }
}
