package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.gui.entity.clint.ClintGuiDescription;
import com.thallium.sdvm.gui.entity.marlon.MarlonGuiDescription;
import com.thallium.sdvm.gui.popup.VillagerPopupDescription;
import com.thallium.sdvm.blocks.vendor.VendingBlockScreenHandler;
import com.thallium.sdvm.items.backpacks.BackpackGuiDescription;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreens
{
    public static ScreenHandlerType<MarlonGuiDescription> MARLON_SHOP;
    public static ScreenHandlerType<ClintGuiDescription> CLINT_SHOP;

    public static ScreenHandlerType<VillagerPopupDescription> VILLAGER_POPUP;

    public static ScreenHandlerType<BackpackGuiDescription> BACKPACK;

    private static PlayerEntity player;
    private static ScreenHandlerContext context;

    public static void registerScreens()
    {
        //Block Guis
        VendingBlockScreenHandler.TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(StardewValley.Mod_ID, "vending_block"), VendingBlockScreenHandler::new);

        //Villager Guis
        MARLON_SHOP = ScreenHandlerRegistry.registerSimple(StardewValley.id("marlon_block"), (syncId, inventory) -> new MarlonGuiDescription(syncId, inventory, player));
        CLINT_SHOP = ScreenHandlerRegistry.registerSimple(StardewValley.id("clint_block"), (syncId, inventory) -> new ClintGuiDescription(syncId, inventory, player));
        VILLAGER_POPUP = ScreenHandlerRegistry.registerSimple(StardewValley.id("villager_popup"), (syncId, inventory) -> new VillagerPopupDescription(syncId, inventory, ScreenHandlerContext.EMPTY, player));

        BACKPACK = ScreenHandlerRegistry.registerSimple(StardewValley.id("backpack"), (syncId, inventory) -> new BackpackGuiDescription(syncId, inventory, ScreenHandlerContext.EMPTY));
    }
}
