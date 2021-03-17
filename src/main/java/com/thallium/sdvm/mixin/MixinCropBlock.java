package com.thallium.sdvm.mixin;

import com.thallium.sdvm.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(CropBlock.class)
public abstract class MixinCropBlock
{
    private boolean repeat = true;

    @Shadow
    public abstract void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random);

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if (world.getBlockState(pos.down()).getBlock() == ModBlocks.FERTILIZED_FARMLAND && repeat) {
            repeat = false;
            randomTick(state, world, pos, random);
        }
    }

    @Inject(method = "randomTick", at = @At("TAIL"), cancellable = true)
    public void cancelRandomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        repeat = true;
    }
}
