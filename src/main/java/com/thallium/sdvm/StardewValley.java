package com.thallium.sdvm;

import com.thallium.sdvm.commands.SeasonCommands;
import com.thallium.sdvm.registry.*;
import com.thallium.sdvm.util.networking.date.DateNetworking;
import com.thallium.sdvm.util.networking.money.CurrencyNetworking;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.net.ResourceManager;

public class StardewValley implements ModInitializer
{
    public static final String Mod_ID = "sdvm";
    public static final Logger LOGGER = LogManager.getLogger();
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
        ModResources.registerResources();

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
