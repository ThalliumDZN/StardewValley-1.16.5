package com.thallium.sdvm.mixin;

import com.thallium.sdvm.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoneMealItem.class)
public class MixinBoneMeal
{
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    public void useOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        if (!world.isClient) {
            boolean success = false;
            int decrementAmount = 1;
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() == Blocks.SAND) {
                world.setBlockState(pos, ModBlocks.FERTILIZED_FARMLAND.getDefaultState());
                success = true;
            } else if (state.getBlock() == Blocks.DIRT) {
                world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
                success = true;
            } else if (state.getBlock() == Blocks.FARMLAND) {
                world.setBlockState(pos, ModBlocks.FERTILIZED_FARMLAND.getDefaultState());
                success = true;
            }
            if (success) {
                context.getStack().decrement(decrementAmount);
                world.syncWorldEvent(2005, pos, 0);
                cir.setReturnValue(ActionResult.SUCCESS);
                cir.cancel();
            }
        }
    }
}
