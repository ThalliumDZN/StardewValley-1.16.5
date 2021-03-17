package com.thallium.sdvm.mixin;

import com.thallium.sdvm.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FarmlandBlock.class)
public class MixinFarmland
{

    @Inject(method = "setToDirt", at = @At("HEAD"), cancellable = true)
    private static void setToDirt(BlockState state, World world, BlockPos pos, CallbackInfo ci) {
        if (state.getBlock() == ModBlocks.FERTILIZED_FARMLAND) {
            world.setBlockState(pos, Block.pushEntitiesUpBeforeBlockChange(state, ModBlocks.FERTILIZED_FARMLAND.getDefaultState(), world, pos));
            ci.cancel();
        }
    }
}
