package com.thallium.sdvm.items.backpacks;

import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlayerInvPanel;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class BackpackGuiDescription extends SyncedGuiDescription
{
    private static final int INVENTORY_SIZE = 12;

    public BackpackGuiDescription(int syncId, PlayerInventory inventory, ScreenHandlerContext sc)
    {
        super(ModScreens.BACKPACK, syncId, inventory, getBlockInventory(sc, INVENTORY_SIZE), getBlockPropertyDelegate(sc));

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        WItemSlot slot = new WItemSlot(inventory, 1, 12, 1, false);
        root.add(slot, 1, 1);

        root.add(this.createPlayerInventoryPanel(), 2, 2);

        root.validate(this);
    }
}
