package com.thallium.sdvm.util.shipping;

import com.thallium.sdvm.blocks.shipping_block.ShippingBlock;
import com.thallium.sdvm.blocks.shipping_block.ShippingBlockInventory;
import com.thallium.sdvm.registry.ModTrinkets;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ShippingUtils
{
    public static final ShippingBlockInventory si = ShippingBlock.getShippingBlockInventory();
    public static final int size = si.size();
    public static int i;

    public static void removeItem(int slot, Item item)
    {
        //remove item from a slot
        for (i = 0; i < size; i++)
            if (si.getStack(i).getItem() == item)
            {
                si.removeItem(item, item.getMaxCount());
            }
    }

    public static void listAllItems()
    {
        //used for testing to see if the list is returning the right items
        MinecraftClient.getInstance().player.sendChatMessage(String.valueOf(si.clearToList()));
    }

    public static void addItem()
    {
        ItemStack stack = new ItemStack(ModTrinkets.rubyRing);

        //return stack if slot is empty
        for (i = 0; i < size; i++)
            if (si.getStack(i).getItem() == Items.AIR)
            {
                si.setStack(i, stack);
                break;
            }
    }
}
