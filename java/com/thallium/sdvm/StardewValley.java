package com.thallium.sdvm;

import com.thallium.sdvm.registry.*;
import com.thallium.sdvm.util.cca.IMoneyComponent;
import com.thallium.sdvm.util.cca.MyComponents;
import com.thallium.sdvm.village.MarlonVillagerProfession;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class StardewValley implements ModInitializer
{
    public static final String Mod_ID = "sdvm";
    public PlayerEntity playerEntity;

    @Override
    public void onInitialize()
    {
        //Main Registry List
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModTools.registerTools();
        ModTrinkets.registerTrinkets();
        ModEntity.registerEntity();
        ModScreens.registerScreens();

        //Villager Registry List
        MarlonVillagerProfession.init();
    }

    //ITEM GROUPS
    public static final ItemGroup TOOL_GROUP = FabricItemGroupBuilder.build(new Identifier(StardewValley.Mod_ID, "tool_group"), () -> new ItemStack(ModTools.RUSTY_SWORD));

    public static Identifier id (String path)
    {
        return new Identifier(Mod_ID, path);
    }
}
