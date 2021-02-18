package com.thallium.sdvm.items.combat.slingshot;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PebbleAmmo extends Item
{
    public PebbleAmmo(Settings settings)
    {
        super(settings);
    }

    public PersistentProjectileEntity createPebble(World world, ItemStack stack, LivingEntity shooter)
    {
        //make arrow entity class
        return null;
    }
}
