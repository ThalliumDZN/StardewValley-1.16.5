package com.thallium.sdvm.gui.entity.marlon;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class MarlonGuiScreen extends CottonInventoryScreen<MarlonGui>
{
    public MarlonGuiScreen(MarlonGui gui, PlayerEntity player, Text title)
    {
        super(gui, player, title);
    }
}
