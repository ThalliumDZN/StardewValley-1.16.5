package com.thallium.sdvm.items.combat.slingshot;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;

import java.util.function.Predicate;

public abstract class RangedSlingshot extends Item
{
    public static final Predicate<ItemStack> SLINGSHOT_AMMO = (stack -> {
        return stack.isItemEqual(new ItemStack(Items.BOOK));
    });

    public RangedSlingshot(Settings settings)
    {
        super(settings);
    }

    public Predicate<ItemStack> getHeldAmmo()
    {
        return this.getAmmo();
    }

    public abstract Predicate<ItemStack> getAmmo();

    public static ItemStack getHeldSlingAmmo(LivingEntity entity, Predicate<ItemStack> predicate)
    {
        if (predicate.test(entity.getStackInHand(Hand.OFF_HAND)))
        {
            return entity.getStackInHand(Hand.OFF_HAND);
        } else {
            return predicate.test(entity.getStackInHand(Hand.MAIN_HAND)) ? entity.getStackInHand(Hand.MAIN_HAND) : ItemStack.EMPTY;
        }
    }

    @Override
    public int getEnchantability()
    {
        return 1;
    }

    public abstract int getRange();

    public ItemStack getAmmoType(ItemStack stack)
    {
        if (!(stack.getItem() instanceof RangedSlingshot))
        {
            return ItemStack.EMPTY;
        } else {
            Predicate<ItemStack> predicate = (Predicate<ItemStack>) ((RangedSlingshot) stack.getItem()).getHeldAmmo();
            assert MinecraftClient.getInstance().player != null;
            ItemStack itemStack = RangedSlingshot.getHeldSlingAmmo(MinecraftClient.getInstance().player, predicate);
            if (!itemStack.isEmpty())
            {
                return itemStack;
            } else
            {
                predicate = ((RangedSlingshot)stack.getItem()).getAmmo();

                for (int i = 0; i < MinecraftClient.getInstance().player.inventory.size(); ++i)
                {
                    ItemStack itemStack2 = MinecraftClient.getInstance().player.inventory.getStack(i);
                    if (predicate.test(itemStack2))
                    {
                        return itemStack2;
                    }
                }

                return MinecraftClient.getInstance().player.abilities.creativeMode ? new ItemStack(Items.BOOK) : ItemStack.EMPTY;
            }
        }
    }

    static {
        SLINGSHOT_AMMO.or(stack ->
        {
            return stack.getItem() == Items.FIREWORK_ROCKET;
        });
    }
}
