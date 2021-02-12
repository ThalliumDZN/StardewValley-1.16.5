package com.thallium.sdvm.items.rings.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class RingEffect extends RingMaterial
{
    private StatusEffect effect;
    private int amplifier;

    public RingEffect(String name, StatusEffect effect, int amplifier, String tooltip) {
        super(name, tooltip);
        this.effect = effect;
        this.amplifier = amplifier;
    }

    @Override
    public void onEquip(PlayerEntity player, ItemStack stack) {
        if(player.hasStatusEffect(effect)) return;
        StatusEffectInstance effectInstance = new StatusEffectInstance(effect, Integer.MAX_VALUE, amplifier, false, false);
        if(player.world.isClient) effectInstance.setPermanent(true);
        try {
            player.addStatusEffect(effectInstance);
        } catch(Exception e) {}
    }

    @Override
    public void onUnequip(PlayerEntity player, ItemStack stack) {
        if(!player.hasStatusEffect(effect)) return;
        player.removeStatusEffect(effect);
    }
}
