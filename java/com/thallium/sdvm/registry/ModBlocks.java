package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.blocks.vendor.VendingBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks
{
    //Basic Blocks
    public static final Block IRIDIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES,3).requiresTool().strength(25.0f, 2000.0f).sounds(BlockSoundGroup.METAL));

    public static void registerBlocks()
    {
        //Basic Blocks
        Registry.register(Registry.BLOCK, new Identifier(StardewValley.Mod_ID, "iridium_block"), IRIDIUM_BLOCK);

        //Machine Blocks
        Registry.register(Registry.BLOCK, new Identifier(StardewValley.Mod_ID, "vending_block"), VendingBlock.INSTANCE);

        //VILLAGER BLOCKS
    }
}
