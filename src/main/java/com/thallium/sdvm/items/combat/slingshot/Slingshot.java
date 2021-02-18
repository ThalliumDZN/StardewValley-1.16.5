package com.thallium.sdvm.items.combat.slingshot;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Vanishable;
import net.minecraft.world.World;

import java.awt.print.Book;
import java.util.function.Predicate;

public class Slingshot extends RangedSlingshot implements Vanishable
{

    public Slingshot(Settings settings)
    {
        super(settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks)
    {
        if (user instanceof PlayerEntity)
        {
            PlayerEntity playerEntity = (PlayerEntity)user;
            boolean bl = playerEntity.abilities.creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemStack = getAmmoType(stack);
            if (!itemStack.isEmpty() || bl)
            {
                if (itemStack.isEmpty())
                {
                    itemStack = new ItemStack(Items.BOOK);
                }

                int i = this.getMaxUseTime(stack) - remainingUseTicks;
                //float f = getPullProgress(i);
                //if ((double)f <= 0.1D)
                {
                    boolean bl2 = bl && itemStack.getItem() == Items.BOOK;
                    if (!world.isClient)
                    {
                        BookItem bookItem = (BookItem)((BookItem)(itemStack.getItem() instanceof BookItem ? itemStack.getItem() : Items.BOOK));
                        //Continue where i left off
                    }
                }
            }
        }
    }

    @Override
    public Predicate<ItemStack> getAmmo()
    {
        return null;
    }

    @Override
    public int getRange()
    {
        return 0;
    }
}
