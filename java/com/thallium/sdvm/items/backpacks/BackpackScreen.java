package com.thallium.sdvm.items.backpacks;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class BackpackScreen extends CottonInventoryScreen<BackpackGuiDescription>
{
    public BackpackScreen(BackpackGuiDescription gui, PlayerEntity player, Text title)
    {
        super(gui, player, title);
    }
}
