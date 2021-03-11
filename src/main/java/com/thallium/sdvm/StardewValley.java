package com.thallium.sdvm;

import com.thallium.sdvm.commands.SeasonCommands;
import com.thallium.sdvm.registry.*;
import com.thallium.sdvm.util.networking.date.DateNetworking;
import com.thallium.sdvm.util.networking.money.CurrencyNetworking;
import com.thallium.sdvm.util.seasons.SeasonList;
import com.thallium.sdvm.village.MarlonVillagerProfession;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

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

        //Networking Registry List
        CurrencyNetworking.init();
        DateNetworking.init();

        //Command Registry List
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> { SeasonCommands.register(dispatcher); });
    }

    //ITEM GROUPS
    public static final ItemGroup TOOL_GROUP = FabricItemGroupBuilder.build(new Identifier(StardewValley.Mod_ID, "tool_group"), () -> new ItemStack(ModTools.RUSTY_SWORD));

    public static Identifier id (String path)
    {
        return new Identifier(Mod_ID, path);
    }
}
