package com.thallium.sdvm.items.watering;

import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.packet.s2c.play.PlaySoundIdS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class WateringCan extends Item
{
    /*
        watering can still needs work, along with MixinFarmlandBlock
    */

    private final int range;
    private final int chance;
    private final int capacity;

    public WateringCan(int range, int capacity, int chance, Settings settings) {
        super(settings);
        this.range = range;
        this.capacity = capacity;
        this.chance = chance;
    }

    public static boolean isFilled(ItemStack stack) {
        if (stack.isEmpty() || !(stack.getItem() instanceof WateringCan)) {
            return false;
        }
        if (stack.getSubTag("sdvm") != null) {
            return stack.getSubTag("sdvm").getInt("StoredFluid") > 0;
        }
        return false;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 10;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!isFilled(stack)) {
            BlockHitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.ANY);
            if (hitResult.getType() == HitResult.Type.MISS) {
                return TypedActionResult.pass(stack);
            } else if (hitResult.getType() != HitResult.Type.BLOCK) {
                return TypedActionResult.pass(stack);
            }

            BlockPos pos = hitResult.getBlockPos();

            if (world.getFluidState(pos).getFluid() instanceof WaterFluid) {
                CompoundTag tag = stack.getOrCreateSubTag("sdvm");
                tag.putInt("StoredFluid", capacity);
            }
        } else {
            int xpos = (int) Math.floor(user.getBlockPos().getX());
            int ypos = (int) Math.floor(user.getBlockPos().getY());
            int zpos = (int) Math.floor(user.getBlockPos().getZ());
            CompoundTag tag = stack.getSubTag("sdvm");
            tag.putInt("StoredFluid", tag.getInt("StoredFluid") - 1);

            if (user instanceof ServerPlayerEntity) {
                ((ServerPlayerEntity)user).networkHandler.sendPacket(new PlaySoundIdS2CPacket(new Identifier("block.wet_grass.place"), SoundCategory.AMBIENT, user.getPos(), 1f, 1f));
            }

            for (float x = -2f; x <= 2f; x += 2f) {
                for (float z = -2f; z <= 2f; z += 2f) {
                    world.addParticle(ParticleTypes.FALLING_WATER, xpos + 0.5f + x * WateringUtils.random.nextDouble(), ypos + 3f - WateringUtils.random.nextDouble(), zpos + 0.5 + z * WateringUtils.random.nextDouble(), x, 1f, z);
                }
            }

            if (world.isClient) {
                return TypedActionResult.success(stack);
            }
            for (int x = -range; x <= range; ++x) {
                for (int y = -3; y <= 3; ++y) {
                    for (int z = -range; z <= range; ++z) {
                        if (WateringUtils.getRandomIntInRange(1, 100) > chance) {
                            continue;
                        }
                        BlockPos cropPos = new BlockPos(xpos + x, ypos + y, zpos + z);
                        BlockState state = world.getBlockState(cropPos);
                        if (state.getBlock() instanceof Fertilizable) {
                            Fertilizable fertilizable = (Fertilizable)state.getBlock();
                            if (fertilizable.isFertilizable(world, cropPos, state, false) && fertilizable.canGrow(world, WateringUtils.random, cropPos, state)) {
                                fertilizable.grow((ServerWorld) world, WateringUtils.random, cropPos, state);
                            }
                        }
                    }
                }
            }
        }
        return TypedActionResult.success(stack);
    }
}
