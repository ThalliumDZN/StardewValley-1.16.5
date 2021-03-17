package com.thallium.sdvm.items.rings;

import com.thallium.sdvm.util.rings.RingMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlowRing extends RingMaterial
{
    /*
        Need to figure out dynamic lighting for the glowing ring
    */

    public GlowRing(String name, String tooltip)
    {
        super(name, tooltip);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack)
    {

    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(new TranslatableText("item.sdvm.glow_ring.tooltip"));
    }
}
