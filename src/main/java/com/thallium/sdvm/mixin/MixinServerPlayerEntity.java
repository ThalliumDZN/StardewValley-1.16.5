package com.thallium.sdvm.mixin;

import com.thallium.sdvm.util.shipping.ShippingUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(ServerPlayerEntity.class)
public class MixinServerPlayerEntity
{
    @Inject(
            at = {@At("HEAD")},
            method = {"wakeUp(ZZ)V"}
    )
    public void wakeUp(boolean bl, boolean updateSleepingPlayers, CallbackInfo ci)
    {
        ShippingUtils.addItem();
        ShippingUtils.listAllItems();
    }
}
