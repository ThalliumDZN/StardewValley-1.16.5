package com.thallium.sdvm.items.rings;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.thallium.sdvm.items.rings.util.RingMaterial;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class RubyRing extends RingMaterial
{
    private static final UUID ATTACK_DAMAGE = UUID.fromString("320d847e-eecd-402f-b6cf-d339d2fa97af");

    public RubyRing(String name, String tooltip)
    {
        super(name,tooltip);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getTrinketModifiers(String group, String slot, UUID uuid, ItemStack stack) {
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = HashMultimap.create();

        modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(ATTACK_DAMAGE, "ATTACK DAMAGE", 20.0D,
                        EntityAttributeModifier.Operation.ADDITION));

        return modifiers;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        tooltip.add(new TranslatableText("item.sdvm.ruby_ring.tooltip"));
    }
}
