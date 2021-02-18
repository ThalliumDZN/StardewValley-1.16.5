package com.thallium.sdvm.items.totems;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WarpTotem extends ConsumableTotem
{
    private static final String name = "counter";

    public WarpTotem(Settings settings)
    {
        super();
    }

    @Override
    public ItemStack onDoneUsing(ItemStack stack, World world, ServerPlayerEntity user)
    {
        BlockPos spawn = user.getSpawnPointPosition();

        if (spawn != null && user.getSpawnPointDimension()
                .getValue()
                .equals(world.getRegistryKey()
                        .getValue())) {
            stack.decrement(1);
            user.teleport(spawn.getX(), spawn.getY(), spawn.getZ());
        }

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(new TranslatableText("item.sdvm.warp_totem.tooltip"));

        if (stack.hasTag()) {
            assert stack.getTag() != null;
            if (stack.getTag().contains("Uses")) {
                tooltip.add(Text.of(Integer.toString(stack.getTag().getInt("uses"))));
            }
        }
    }
}
