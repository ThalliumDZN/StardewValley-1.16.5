package com.thallium.sdvm.blocks.keg;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class CurrencyBookScreen extends CottonInventoryScreen<CurrencyBookGuiDescription>
{
    public CurrencyBookScreen(CurrencyBookGuiDescription description, PlayerEntity player, Text title)
    {
        super(description, player);
    }
}
