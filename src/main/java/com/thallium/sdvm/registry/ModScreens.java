package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.blocks.shipping_block.ShippingBlockGui;
import com.thallium.sdvm.gui.entity.clint.ClintGui;
import com.thallium.sdvm.gui.entity.marlon.MarlonGui;
import com.thallium.sdvm.gui.fishing.FishingGui;
import com.thallium.sdvm.gui.frienship.FriendshipGui;
import com.thallium.sdvm.gui.popup.VillagerPopupGui;
import com.thallium.sdvm.items.backpacks.BackpackGui;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreens
{
    private static PlayerEntity player;
    private static ScreenHandlerContext context;

    public static ScreenHandlerType<MarlonGui> MARLON_SHOP;
    public static ScreenHandlerType<ClintGui> CLINT_SHOP;

    public static ScreenHandlerType<FriendshipGui> FRIENDSHIP_SCREEN;
    public static ScreenHandlerType<FishingGui> FISHING_SCREEN;

    public static ScreenHandlerType<VillagerPopupGui> VILLAGER_POPUP;

    public static ScreenHandlerType<ShippingBlockGui> SELL_BLOCK;

    public static ScreenHandlerType<BackpackGui> BACKPACK;

    public static void registerScreens()
    {
        //Villager Guis
        MARLON_SHOP = ScreenHandlerRegistry.registerSimple(StardewValley.id("marlon_block"), MarlonGui::new);
        CLINT_SHOP = ScreenHandlerRegistry.registerSimple(StardewValley.id("clint_block"), (syncId, inventory) -> new ClintGui(syncId, inventory, player));
        VILLAGER_POPUP = ScreenHandlerRegistry.registerSimple(StardewValley.id("villager_popup"), (syncId, inventory) -> new VillagerPopupGui(syncId, inventory, ScreenHandlerContext.EMPTY, player));

        FRIENDSHIP_SCREEN = ScreenHandlerRegistry.registerSimple(StardewValley.id("friendship_screen"), (syncId, inventory) -> new FriendshipGui(syncId, inventory, player));
        FISHING_SCREEN = ScreenHandlerRegistry.registerSimple(StardewValley.id("fishing_screen"), (syncId, inventory) -> new FishingGui(syncId, inventory, player));

        SELL_BLOCK = ScreenHandlerRegistry.registerSimple(StardewValley.id("sell_block"), (syncId, inventory) -> new ShippingBlockGui(syncId, inventory, player));

        BACKPACK = ScreenHandlerRegistry.registerSimple(StardewValley.id("backpack"), (syncId, inventory) -> new BackpackGui(syncId, inventory, ScreenHandlerContext.EMPTY));
    }
}
