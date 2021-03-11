package com.thallium.sdvm.gui.entity.marlon;

import com.thallium.sdvm.gui.widgets.WBuyButton;
import com.thallium.sdvm.gui.widgets.WShopPanel;
import com.thallium.sdvm.registry.ModScreens;
import com.thallium.sdvm.registry.ModTools;
import com.thallium.sdvm.registry.ModTrinkets;
import com.thallium.sdvm.util.networking.money.CurrencyUtils;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;

public class MarlonGui extends SyncedGuiDescription
{
    public MarlonGui(int syncId, PlayerInventory playerInventory)
    {
        super(ModScreens.MARLON_SHOP, syncId, playerInventory);

        // Sell List
        MarlonSellList.registerSellList();

        // LibGui Info
        WShopPanel root = new WShopPanel();
        root.setSize(260, 105);
        setRootPanel(root);

        WPlainPanel box = new WPlainPanel();
        box.addPainters();
        box.setSize(260, 105);

        WScrollPanel scrollPanel = new WScrollPanel(box);
        root.add(scrollPanel, 4, 4, 260, 97);
        scrollPanel.setScrollingHorizontally(TriState.FALSE);
        scrollPanel.setScrollingVertically(TriState.TRUE);
        scrollPanel.setSize(260, 97);

        box.add(MarlonSellList.woodenBlade, 0, 0, 252, 25);
        box.add(MarlonSellList.silverSaber, 0, 25, 252, 25);
        box.add(MarlonSellList.pirateSword, 0, 50, 252, 25);
        box.add(MarlonSellList.cutlass, 0, 75, 252, 25);
        box.add(MarlonSellList.templarsBlade, 0, 100, 252, 25);
        box.add(MarlonSellList.boneSword, 0, 125, 252, 25);
        box.add(MarlonSellList.steelFalchion, 0, 150, 252, 25);
        box.add(MarlonSellList.lavaKatana, 0, 175, 252, 25);
        box.add(MarlonSellList.galaxySword, 0, 200, 252, 25);
        box.add(MarlonSellList.rubyRing, 0, 225, 252, 25);

        root.validate(this);
    }

    @Override
    public void addPainters() 
    {

    }
}
