package com.thallium.sdvm.blocks.currency_book;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class CurrencyBookScreen extends CottonInventoryScreen<CurrencyBookGui>
{
    public CurrencyBookScreen(CurrencyBookGui description, PlayerEntity player, Text title)
    {
        super(description, player);
    }
}
