package com.thallium.sdvm.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(FarmlandBlock.class)
public class MixinFarmland
{
    @Final
    @Shadow
    public static IntProperty MOISTURE;

    /**
     * @author Thallium
     */
    @Overwrite
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        int i = (Integer)state.get(MOISTURE);
        if (!isWatered(world, pos))
        {
            assert MinecraftClient.getInstance().world != null;
            if (MinecraftClient.getInstance().world.getTime() == 0)
            {
                world.setBlockState(pos, (BlockState)state.with(MOISTURE, 0));
                System.out.println("A NEW DAY HAS STARTED!");
            }
        }
            else
            {
                world.setBlockState(pos, (BlockState)state.with(MOISTURE, 0));
            }
    }

    private static boolean isWatered(WorldView world, BlockPos pos)
    {
        return false;
    }
}
