package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.blocks.vendor.VendingBlock;
import com.thallium.sdvm.items.backpacks.Backpack;
import com.thallium.sdvm.items.watering.WateringCan;
import com.thallium.sdvm.items.food.FoodList;
import com.thallium.sdvm.items.totems.WarpTotem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{
    //Items
    public static final Item IRIDIUM_ORE = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item IRIDIUM_BAR = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item TELEPORT_TOTEM = new Item(new Item.Settings().group(ItemGroup.TOOLS).maxCount(1));

    //Block Items
    public static final BlockItem IRIDIUM_BLOCK = new BlockItem(ModBlocks.IRIDIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    //Warp Totems
    public static final Item WARP_TOTEM = new WarpTotem(new FabricItemSettings());

    //Food Items
    public static final Item CAVE_CARROT = new Item(new Item.Settings().group(ItemGroup.FOOD).food(FoodList.CAVE_CARROT));

    //Watering Cans
    public static final Item WATERING_CAN = new WateringCan(new FabricItemSettings());

    //Backpacks
    public static final Item BACKPACK = new Backpack();

    public static void registerItems()
    {
        //Items
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "iridium_ore"), IRIDIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "iridium_bar"), IRIDIUM_BAR);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "teleport_totem"), TELEPORT_TOTEM);

        //Block Items
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "iridium_block"), IRIDIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "vending_block"), VendingBlock.ITEM);

        //Warp Totems
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "warp_totem"), WARP_TOTEM);

        //Food Items
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "cave_carrot"), CAVE_CARROT);

        //Watering Cans
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "watering_can"), WATERING_CAN);

        //Backpacks
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "backpack"), BACKPACK);

    }
}
