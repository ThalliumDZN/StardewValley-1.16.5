package com.thallium.sdvm.gui.popup;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class VillagerPopupScreen extends CottonInventoryScreen<VillagerPopupDescription>
{
    public VillagerPopupScreen(VillagerPopupDescription description, PlayerEntity player, Text title)
    {
        super(description, player, title);
    }
}
