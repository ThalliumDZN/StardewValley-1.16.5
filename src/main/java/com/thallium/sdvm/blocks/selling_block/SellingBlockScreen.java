package com.thallium.sdvm.blocks.selling_block;

import com.thallium.sdvm.blocks.vendor.VendingBlockScreenHandler;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;

public class SellingBlockScreen extends CottonInventoryScreen<SellingBlockGui>
{
    public SellingBlockScreen(SellingBlockGui description, PlayerEntity player, Text title)
    {
        super(description, player, title);
    }
}
