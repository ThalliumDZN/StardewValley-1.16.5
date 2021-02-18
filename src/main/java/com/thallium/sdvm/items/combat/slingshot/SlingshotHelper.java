package com.thallium.sdvm.items.combat.slingshot;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.function.Predicate;

public class SlingshotHelper
{
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

                return MinecraftClient.getInstance().player.abilities.creativeMode ? new ItemStack(Items.STONE) : ItemStack.EMPTY;
            }
        }
    }
}
