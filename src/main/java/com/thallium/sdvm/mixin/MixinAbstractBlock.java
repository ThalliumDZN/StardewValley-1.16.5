package com.thallium.sdvm.mixin;

import com.thallium.sdvm.registry.ModBlocks;
import net.minecraft.block.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class MixinAbstractBlock
{
    @Shadow
    public abstract Block getBlock();

    @Inject(method = "isOf", at = @At("HEAD"), cancellable = true)
    public void isOf(Block block, CallbackInfoReturnable<Boolean> cir) {
        boolean isFarmland = block instanceof FarmlandBlock && getBlock() == ModBlocks.FERTILIZED_FARMLAND;
        if (isFarmland) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
