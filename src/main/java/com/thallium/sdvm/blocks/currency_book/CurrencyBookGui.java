package com.thallium.sdvm.blocks.currency_book;

import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

public class CurrencyBookGui extends SyncedGuiDescription
{
    public CurrencyBookGui(int syncId, PlayerInventory inventory, PlayerEntity player)
    {
        super(ModScreens.CURRENCY_BOOK, syncId, inventory);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        root.validate(this);
    }
}
