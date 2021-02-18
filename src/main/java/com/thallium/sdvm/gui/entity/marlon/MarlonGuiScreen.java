package com.thallium.sdvm.gui.entity.marlon;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class MarlonGuiScreen extends CottonInventoryScreen<MarlonGuiDescription>
{
    public MarlonGuiScreen(MarlonGuiDescription gui, PlayerEntity player, Text title)
    {
        super(gui, player, title);
    }
}
