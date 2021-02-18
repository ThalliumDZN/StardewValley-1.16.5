package com.thallium.sdvm.items.rings;

import com.thallium.sdvm.items.rings.util.RingMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SmallMagnetRing extends RingMaterial
{
    public SmallMagnetRing(String name, String tooltip)
    {
        super(name,tooltip);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        super.tick(player, stack);
        if(!player.world.isClient && !player.isSneaking()) {
            int range = 2;
            BlockPos pos = player.getBlockPos();
            List<ItemEntity> entities = player.world.getEntitiesByClass(ItemEntity.class, new Box(pos.getX() + range, pos.getY() + range, pos.getZ() + range, pos.getX() - range, pos.getY() - range, pos.getZ() - range), null);
            for(ItemEntity item : entities) {
                if(item.isAlive() && !item.cannotPickup()) {
                    item.onPlayerCollision(player);
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(new TranslatableText("item.sdvm.small_magnet_ring.tooltip"));
    }
}
