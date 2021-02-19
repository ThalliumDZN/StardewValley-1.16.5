package com.thallium.sdvm.blocks.keg;

import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class CurrencyBookGuiDescription extends SyncedGuiDescription
{
    public CurrencyBookGuiDescription(int syncId, PlayerInventory inventory, PlayerEntity player)
    {
        super(ModScreens.CURRENCY_BOOK, syncId, inventory);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        root.validate(this);
    }
}
