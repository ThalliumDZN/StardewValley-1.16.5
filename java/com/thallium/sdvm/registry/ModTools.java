package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.items.combat.ClubMaterials;
import com.thallium.sdvm.items.combat.DaggerMaterials;
import com.thallium.sdvm.items.combat.SwordMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import sun.security.provider.SHA;

public class ModTools
{
    //Swords
    public static final ToolItem RUSTY_SWORD = new SwordItem(SwordMaterials.RUSTY_SWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem STEEL_SMALLSWORD = new SwordItem(SwordMaterials.STEEL_SMALLSWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem WOODEN_BLADE = new SwordItem(SwordMaterials.WOODEN_BLADE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem PIRATES_SWORD = new SwordItem(SwordMaterials.PIRATES_SWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem SILVER_SABER = new SwordItem(SwordMaterials.SILVER_SABER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem CUTLASS = new SwordItem(SwordMaterials.CUTLASS, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem FOREST_SWORD = new SwordItem(SwordMaterials.FOREST_SWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem IRON_EDGE = new SwordItem(SwordMaterials.IRON_EDGE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem INSECT_HEAD = new SwordItem(SwordMaterials.INSECT_HEAD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem BONE_SWORD = new SwordItem(SwordMaterials.BONE_SWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem CLAYMORE = new SwordItem(SwordMaterials.CLAYMORE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem NEPTUNES_GLAIVE = new SwordItem(SwordMaterials.NEPTUNES_GLAIVE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem TEMPLARS_BLADE = new SwordItem(SwordMaterials.TEMPLARS_BLADE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem OBSIDIAN_EDGE = new SwordItem(SwordMaterials.OBSIDIAN_EDGE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem OSSIFIED_BLADE = new SwordItem(SwordMaterials.OSSIFIED_BLADE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem TEMPERED_BLADE = new SwordItem(SwordMaterials.TEMPERED_BROADSWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem YETI_TOOTH = new SwordItem(SwordMaterials.YETI_TOOTH, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem STEEL_FALCHION = new SwordItem(SwordMaterials.STEEL_FALCHION, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem DARK_SWORD = new SwordItem(SwordMaterials.DARK_SWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem LAVA_KATANA = new SwordItem(SwordMaterials.LAVA_KATANA, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem DRAGONTOOTH_CUTLASS = new SwordItem(SwordMaterials.DRAGONTOOTH_CUTLASS, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem DWARF_SWORD = new SwordItem(SwordMaterials.DWARF_SWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem GALAXY_SWORD = new SwordItem(SwordMaterials.GALAXY_SWORD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem INFINITY_BLADE = new SwordItem(SwordMaterials.INFINITY_BLADE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));

    //Daggers
    public static final ToolItem CARVING_KNIFE = new SwordItem(DaggerMaterials.CARVING_KNIFE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem IRON_DIRK = new SwordItem(DaggerMaterials.IRON_DIRK, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem WIND_SPIRE = new SwordItem(DaggerMaterials.WIND_SPIRE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem ELF_BLADE = new SwordItem(DaggerMaterials.ELF_BLADE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem BURGLARS_SHANK = new SwordItem(DaggerMaterials.BURGLARS_SHANK, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem CRYSTAL_DAGGER = new SwordItem(DaggerMaterials.CRYSTAL_DAGGER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem SHADOW_DAGGER = new SwordItem(DaggerMaterials.SHADOW_DAGGER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem BROKEN_TRIDENT = new SwordItem(DaggerMaterials.BROKEN_TRIDENT, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem WICKED_KRIS = new SwordItem(DaggerMaterials.WICKED_KRIS, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem GALAXY_DAGGER = new SwordItem(DaggerMaterials.GALAXY_DAGGER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem DWARF_DAGGER = new SwordItem(DaggerMaterials.DWARF_DAGGER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem DRAGONTOOTH_SHIV = new SwordItem(DaggerMaterials.DRAGONTOOTH_SHIV, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem IRIDIUM_NEEDLE = new SwordItem(DaggerMaterials.IRIDIUM_NEEDLE, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem INFINITY_DAGGER = new SwordItem(DaggerMaterials.INFINITY_DAGGER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));

    //Clubs
    public static final ToolItem FEMUR = new SwordItem(ClubMaterials.FEMUR, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem WOOD_CLUB = new SwordItem(ClubMaterials.WOOD_CLUB, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem WOOD_MALLET = new SwordItem(ClubMaterials.WOOD_MALLET, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem LEAD_ROD = new SwordItem(ClubMaterials.LEAD_ROD, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem KUDGEL = new SwordItem(ClubMaterials.KUDGEL, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem THE_SLAMMER = new SwordItem(ClubMaterials.THE_SLAMMER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem GALAXY_HAMMER = new SwordItem(ClubMaterials.GALAXY_HAMMER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem DWARF_HAMMER = new SwordItem(ClubMaterials.DWARF_HAMMER, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem DRAGONTOOTH_CLUB = new SwordItem(ClubMaterials.DRAGONTOOTH_SHIV, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));
    public static final ToolItem INFINITY_GAVEL = new SwordItem(ClubMaterials.INFINITY_GAVEL, 3, -2.4F, new Item.Settings().group(StardewValley.TOOL_GROUP));

    public static void registerTools()
    {
        //Swords
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "rusty_sword"), RUSTY_SWORD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "steel_smallsword"), STEEL_SMALLSWORD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "wooden_blade"), WOODEN_BLADE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "pirates_sword"), PIRATES_SWORD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "silver_saber"), SILVER_SABER);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "cutlass"), CUTLASS);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "forest_sword"), FOREST_SWORD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "iron_edge"), IRON_EDGE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "insect_head"), INSECT_HEAD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "bone_sword"), BONE_SWORD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "claymore"), CLAYMORE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "neptunes_glaive"), NEPTUNES_GLAIVE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "templars_blade"), TEMPLARS_BLADE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "obsidian_edge"), OBSIDIAN_EDGE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "ossified_blade"), OSSIFIED_BLADE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "tempered_blade"), TEMPERED_BLADE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "yeti_tooth"), YETI_TOOTH);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "steel_falchion"), STEEL_FALCHION);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "dark_sword"), DARK_SWORD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "lava_katana"), LAVA_KATANA);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "dragontooth_cutlass"), DRAGONTOOTH_CUTLASS);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "dwarf_sword"), DWARF_SWORD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "galaxy_sword"), GALAXY_SWORD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "infinity_blade"), INFINITY_BLADE);

        //Daggers
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "carving_knife"), CARVING_KNIFE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "iron_dirk"), IRON_DIRK);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "wind_spire"), WIND_SPIRE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "elf_blade"), ELF_BLADE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "burglars_shank"), BURGLARS_SHANK);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "crystal_dagger"), CRYSTAL_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "shadow_dagger"), SHADOW_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "broken_trident"), BROKEN_TRIDENT);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "wicked_kris"), WICKED_KRIS);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "galaxy_dagger"), GALAXY_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "dwarf_dagger"), DWARF_DAGGER);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "dragontooth_shiv"), DRAGONTOOTH_SHIV);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "iridium_needle"), IRIDIUM_NEEDLE);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "infinity_dagger"), INFINITY_DAGGER);

        //Clubs
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "femur"), FEMUR);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "wood_club"), WOOD_CLUB);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "wood_mallet"), WOOD_MALLET);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "lead_rod"), LEAD_ROD);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "kudgel"), KUDGEL);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "the_slammer"), THE_SLAMMER);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "galaxy_hammer"), GALAXY_HAMMER);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "dwarf_hammer"), DWARF_HAMMER);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "dragontooth_club"), DRAGONTOOTH_CLUB);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "infinity_gavel"), INFINITY_GAVEL);
    }
}
