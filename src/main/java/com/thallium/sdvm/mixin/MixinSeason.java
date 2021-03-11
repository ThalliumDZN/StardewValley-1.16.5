package com.thallium.sdvm.mixin;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.thallium.sdvm.util.seasons.Season;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public class MixinSeason
{
    @Inject(
            at = @At("HEAD"),
            method = "canPlaceAt(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z",
            cancellable = true
    )
    public void canPlaceAt(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Bool> ci)
    {
        if (Season.isWinter())
        {
            System.out.println("is winter");
            ci.cancel();
        }
    }
}
