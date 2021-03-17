package com.thallium.sdvm.mixin;

import com.thallium.sdvm.blocks.shipping_block.ShippingBlock;
import com.thallium.sdvm.blocks.shipping_block.ShippingBlockInventory;
import com.thallium.sdvm.gui.profit.ProfitGui;
import com.thallium.sdvm.gui.profit.ProfitScreen;
import com.thallium.sdvm.registry.ModTrinkets;
import com.thallium.sdvm.util.networking.date.DateUtils;
import com.thallium.sdvm.util.shipping.ShippingUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.somnus.MixinHooks;
import top.theillusivec4.somnus.api.PlayerSleepEvents;
import top.theillusivec4.somnus.api.WorldSleepEvents;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity
{
    @Inject(
            at = {@At("HEAD")},
            method = {"wakeUp(ZZ)V"}
    )
    public void wakeUp(boolean bl, boolean updateSleepingPlayers, CallbackInfo ci)
    {
        //DateUtils.newDay(1);

        MinecraftClient MC = MinecraftClient.getInstance();
        MC.openScreen(new ProfitScreen(new ProfitGui()));
    }
}
