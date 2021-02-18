package com.thallium.sdvm;

import com.thallium.sdvm.entity.villagers.clint.ClintEntityRenderer;
import com.thallium.sdvm.gui.entity.clint.ClintGuiDescription;
import com.thallium.sdvm.gui.entity.clint.ClintGuiScreen;
import com.thallium.sdvm.gui.entity.marlon.MarlonGuiScreen;
import com.thallium.sdvm.gui.entity.marlon.MarlonGuiDescription;
import com.thallium.sdvm.blocks.vendor.*;
import com.thallium.sdvm.entity.villagers.marlon.MarlonEntityRenderer;
import com.thallium.sdvm.gui.calendar.CalendarGui;
import com.thallium.sdvm.gui.calendar.CalendarScreen;
import com.thallium.sdvm.gui.hud.StardewHud;
import com.thallium.sdvm.items.backpacks.BackpackGuiDescription;
import com.thallium.sdvm.items.backpacks.BackpackScreen;
import com.thallium.sdvm.registry.ModEntity;
import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.client.CottonHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class StardewValleyClient implements ClientModInitializer
{
    //Keybindings
    private static KeyBinding calendarKey;

    @Override
    public void onInitializeClient()
    {
        ScreenRegistry.register(VendingBlockScreenHandler.TYPE, VendingBlockScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(VendingBlock.INSTANCE, RenderLayer.getTranslucent());
        BlockEntityRendererRegistry.INSTANCE.register(VendingBlockEntity.TYPE, VendingBlockEntityRenderer::new);

        //Hud Additions
        CottonHud.INSTANCE.add(new StardewHud(),405,  -20, 10, 10);

        //Keybinding Additions
        calendarKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.sdvm.calendar", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_C, "category.sdvm.calendar"));

        ClientTickEvents.END_CLIENT_TICK.register(client ->
        {
            while (calendarKey.wasPressed())
            {
                //client.player.sendMessage(new LiteralText("Key 1 was pressed!"), false);
                //CottonHud.INSTANCE.add(new CalendarGui(), 1, 1, 340, 168);
                MinecraftClient.getInstance().openScreen(new CalendarScreen(new CalendarGui()));
            }
        });

        //Rendering Entities
        EntityRendererRegistry.INSTANCE.register(ModEntity.CUBE, (dispatcher, context) ->
        {
            return new MarlonEntityRenderer(dispatcher);
        });

        EntityRendererRegistry.INSTANCE.register(ModEntity.CLINT, (dispatcher, context) ->
        {
            return new ClintEntityRenderer(dispatcher);
        });

        //Screen Registry
        ScreenRegistry.<MarlonGuiDescription, MarlonGuiScreen>register(ModScreens.MARLON_SHOP, (gui, inventory, title) -> new MarlonGuiScreen(gui, inventory.player, title));
        ScreenRegistry.<ClintGuiDescription, ClintGuiScreen>register(ModScreens.CLINT_SHOP, (gui, inventory, title) -> new ClintGuiScreen(gui, inventory.player, title));
        ScreenRegistry.<BackpackGuiDescription, BackpackScreen>register(ModScreens.BACKPACK, (gui, inventory, title) -> new BackpackScreen(gui, inventory.player, title));
    }
}
