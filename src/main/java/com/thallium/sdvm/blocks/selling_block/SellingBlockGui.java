package com.thallium.sdvm.blocks.selling_block;

import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class SellingBlockGui extends SyncedGuiDescription
{
    private static final int INVENTORY_SIZE = 1;

    public SellingBlockGui(int syncId, PlayerInventory inventory, ScreenHandlerContext context)
    {
        super(ModScreens.SELL_BLOCK, syncId, inventory, getBlockInventory(context, 1), getBlockPropertyDelegate(context));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        WItemSlot itemSlot = WItemSlot.of(blockInventory, 0);
        root.add(itemSlot, 4, 1);

        root.add(this.createPlayerInventoryPanel(), 0, 3);

        root.validate(this);
    }
}
