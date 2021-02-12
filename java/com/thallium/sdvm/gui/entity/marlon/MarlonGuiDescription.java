package com.thallium.sdvm.gui.entity.marlon;

import com.thallium.sdvm.gui.widgets.wBuyButton;
import com.thallium.sdvm.gui.widgets.wShopPanel;
import com.thallium.sdvm.registry.ModScreens;
import com.thallium.sdvm.registry.ModTools;
import com.thallium.sdvm.registry.ModTrinkets;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

public class MarlonGuiDescription extends SyncedGuiDescription
{
    public MarlonGuiDescription(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        super(ModScreens.MARLON_SHOP, syncId, playerInventory);

        // Sell List
        wBuyButton woodenBlade = new wBuyButton(new ItemIcon(new ItemStack(ModTools.WOODEN_BLADE)), new LiteralText("Wooden Blade"), new LiteralText("100G"));
        woodenBlade.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.WOODEN_BLADE)); });

        wBuyButton silverSaber = new wBuyButton(new ItemIcon(new ItemStack(ModTools.SILVER_SABER)), new LiteralText("Silver Saber"), new LiteralText("100G"));
        silverSaber.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.SILVER_SABER)); });

        wBuyButton pirateSword = new wBuyButton(new ItemIcon(new ItemStack(ModTools.PIRATES_SWORD)), new LiteralText("Pirate's Sword"), new LiteralText("100G"));
        pirateSword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.PIRATES_SWORD)); });

        wBuyButton cutlass = new wBuyButton(new ItemIcon(new ItemStack(ModTools.CUTLASS)), new LiteralText("Cutlass"), new LiteralText("100G"));
        cutlass.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.CUTLASS)); });

        wBuyButton claymore = new wBuyButton(new ItemIcon(new ItemStack(ModTools.CLAYMORE)), new LiteralText("Claymore"), new LiteralText("100G"));
        claymore.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.CLAYMORE)); });

        wBuyButton templarsBlade = new wBuyButton(new ItemIcon(new ItemStack(ModTools.TEMPLARS_BLADE)), new LiteralText("Templar's Blade"), new LiteralText("100G"));
        templarsBlade.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.TEMPLARS_BLADE)); });

        wBuyButton boneSword = new wBuyButton(new ItemIcon(new ItemStack(ModTools.BONE_SWORD)), new LiteralText("Bone Sword"), new LiteralText("100G"));
        boneSword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.BONE_SWORD)); });

        wBuyButton steelFalchion = new wBuyButton(new ItemIcon(new ItemStack(ModTools.STEEL_FALCHION)), new LiteralText("Steel Falchion"), new LiteralText("100G"));
        steelFalchion.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.STEEL_FALCHION)); });

        wBuyButton lavaKatana = new wBuyButton(new ItemIcon(new ItemStack(ModTools.LAVA_KATANA)), new LiteralText("Lava Katana"), new LiteralText("100G"));
        lavaKatana.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.LAVA_KATANA)); });

        wBuyButton galaxySword = new wBuyButton(new ItemIcon(new ItemStack(ModTools.GALAXY_SWORD)), new LiteralText("Galaxy Sword"), new LiteralText("100G"));
        galaxySword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.GALAXY_SWORD)); });

        wBuyButton rubyRing = new wBuyButton(new ItemIcon(new ItemStack(ModTrinkets.rubyRing)), new LiteralText("Ruby Ring"), new LiteralText("100G"));
        rubyRing.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTrinkets.rubyRing)); });

        // LibGui Info
        wShopPanel root = new wShopPanel();
        root.setSize(260, 105);
        setRootPanel(root);
        //root.setBackgroundPainter(PANEL);
        //root.addPainters();

        //WSprite sprite = new WSprite(shopPanel);
        //root.add(sprite, 0, 0, 260, 105);

        WPlainPanel box = new WPlainPanel();
        box.addPainters();
        box.setSize(260, 105);

        WScrollPanel scrollPanel = new WScrollPanel(box);
        root.add(scrollPanel, 4, 4, 260, 97);
        scrollPanel.setScrollingHorizontally(TriState.FALSE);
        scrollPanel.setScrollingVertically(TriState.TRUE);
        //scrollPanel.setBackgroundPainter(PANEL);
        scrollPanel.setSize(260, 97);

        box.add(woodenBlade, 0, 0, 252, 25);
        box.add(silverSaber, 0, 25, 252, 25);
        box.add(pirateSword, 0, 50, 252, 25);
        box.add(cutlass, 0, 75, 252, 25);
        box.add(templarsBlade, 0, 100, 252, 25);
        box.add(boneSword, 0, 125, 252, 25);
        box.add(steelFalchion, 0, 150, 252, 25);
        box.add(lavaKatana, 0, 175, 252, 25);
        box.add(galaxySword, 0, 200, 252, 25);
        box.add(rubyRing, 0, 225, 252, 25);

        root.validate(this);
    }

    @Override
    public void addPainters() 
    {

    }
}
