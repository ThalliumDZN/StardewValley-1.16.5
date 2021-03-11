package com.thallium.sdvm;

import com.thallium.sdvm.blocks.currency_book.CurrencyBookBlockEntityRenderer;
import com.thallium.sdvm.blocks.currency_book.CurrencyBookGui;
import com.thallium.sdvm.blocks.currency_book.CurrencyBookScreen;
import com.thallium.sdvm.blocks.selling_block.SellingBlockGui;
import com.thallium.sdvm.blocks.selling_block.SellingBlockScreen;
import com.thallium.sdvm.entity.villagers.clint.ClintEntityRenderer;
import com.thallium.sdvm.gui.calendar.fall.FallCalendarGui;
import com.thallium.sdvm.gui.calendar.fall.FallScreen;
import com.thallium.sdvm.gui.calendar.summer.SummerCalendarGui;
import com.thallium.sdvm.gui.calendar.summer.SummerScreen;
import com.thallium.sdvm.gui.calendar.winter.WinterCalendarGui;
import com.thallium.sdvm.gui.calendar.winter.WinterScreen;
import com.thallium.sdvm.gui.entity.clint.ClintGui;
import com.thallium.sdvm.gui.entity.clint.ClintGuiScreen;
import com.thallium.sdvm.gui.entity.marlon.MarlonGuiScreen;
import com.thallium.sdvm.gui.entity.marlon.MarlonGui;
import com.thallium.sdvm.entity.villagers.marlon.MarlonEntityRenderer;
import com.thallium.sdvm.gui.calendar.spring.SpringCalendarGui;
import com.thallium.sdvm.gui.calendar.spring.SpringScreen;
import com.thallium.sdvm.gui.hud.StardewHud;
import com.thallium.sdvm.items.backpacks.BackpackGui;
import com.thallium.sdvm.items.backpacks.BackpackScreen;
import com.thallium.sdvm.registry.ModEntity;
import com.thallium.sdvm.registry.ModScreens;
import com.thallium.sdvm.util.seasons.Season;
import io.github.cottonmc.cotton.gui.client.CottonHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
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
        //Hud Additions
        CottonHud.INSTANCE.add(new StardewHud(),405,  -20, 10, 10);

        //Keybinding Additions
        calendarKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.sdvm.calendar", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_C, "category.sdvm.calendar"));

        ClientTickEvents.END_CLIENT_TICK.register(client ->
        {
            while (calendarKey.isPressed())
            {
                if (Season.isSpring())
                {
                    client.openScreen(new SpringScreen(new SpringCalendarGui()));
                } else if (Season.isSummer())
                {
                    client.openScreen(new SummerScreen(new SummerCalendarGui()));
                } else if (Season.isFall())
                {
                    client.openScreen(new FallScreen(new FallCalendarGui()));
                } else if (Season.isWinter())
                {
                    client.openScreen(new WinterScreen(new WinterCalendarGui()));
                }
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

        BlockEntityRendererRegistry.INSTANCE.register(ModEntity.CURRENCY_BOOK, CurrencyBookBlockEntityRenderer::new);



        //Screen Registry
        ScreenRegistry.<MarlonGui, MarlonGuiScreen>register(ModScreens.MARLON_SHOP, (gui, inventory, title) -> new MarlonGuiScreen(gui, inventory.player, title));
        ScreenRegistry.<ClintGui, ClintGuiScreen>register(ModScreens.CLINT_SHOP, (gui, inventory, title) -> new ClintGuiScreen(gui, inventory.player, title));
        ScreenRegistry.<BackpackGui, BackpackScreen>register(ModScreens.BACKPACK, (gui, inventory, title) -> new BackpackScreen(gui, inventory.player, title));
        ScreenRegistry.<CurrencyBookGui, CurrencyBookScreen>register(ModScreens.CURRENCY_BOOK, (gui, inventory, title) -> new CurrencyBookScreen(gui, inventory.player, title));
        ScreenRegistry.<SellingBlockGui, SellingBlockScreen>register(ModScreens.SELL_BLOCK, ((sellingBlockGui, playerInventory, text) -> new SellingBlockScreen(sellingBlockGui, playerInventory.player, text)));
    }
}
