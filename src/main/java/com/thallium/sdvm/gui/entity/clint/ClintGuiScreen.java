package com.thallium.sdvm.gui.entity.clint;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class ClintGuiScreen extends CottonInventoryScreen<ClintGuiDescription>
{
    public ClintGuiScreen(ClintGuiDescription description, PlayerEntity player, Text title)
    {
        super(description, player, title);
    }
}
