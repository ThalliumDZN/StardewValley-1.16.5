package com.thallium.sdvm.mixin;

import com.thallium.sdvm.util.networking.date.DateUtils;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class MixinDate
{
    @Inject(
            at = {@At("HEAD")},
            method = {"wakeUp(ZZ)V"}
    )
    public void wakeUp(boolean bl, boolean updateSleepingPlayers, CallbackInfo ci)
    {
        DateUtils.newDay(1);
    }
}
