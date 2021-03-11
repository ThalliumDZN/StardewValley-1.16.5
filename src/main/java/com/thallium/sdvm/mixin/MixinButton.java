package com.thallium.sdvm.mixin;

import com.thallium.sdvm.gui.fishing.FishingGui;
import com.thallium.sdvm.gui.fishing.FishingScreen;
import com.thallium.sdvm.gui.frienship.FriendshipGui;
import com.thallium.sdvm.gui.frienship.FriendshipScreen;
import com.thallium.sdvm.gui.widgets.WInventoryButton;
import com.thallium.sdvm.registry.ModTools;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class MixinButton extends AbstractInventoryScreen<PlayerScreenHandler>
{
    public MixinButton(PlayerScreenHandler screenHandler, PlayerInventory playerInventory, Text text)
    {
        super(screenHandler, playerInventory, text);
    }

    @Inject(at = @At("RETURN"), method = "init")
    private void addButton(CallbackInfo ci)
    {
        this.addButton(new ButtonWidget(this.width / 2 - 100, y, 20, 20, new LiteralText(""), (buttonWidget) -> {
            this.client.openScreen(new FishingScreen(new FishingGui(1, playerInventory, client.player)));
        }));
    }
}
