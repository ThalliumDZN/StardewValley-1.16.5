package com.thallium.sdvm.gui.entity.marlon;

import com.thallium.sdvm.gui.widgets.WBuyButton;
import com.thallium.sdvm.gui.widgets.WShopPanel;
import com.thallium.sdvm.registry.ModItems;
import com.thallium.sdvm.registry.ModScreens;
import com.thallium.sdvm.registry.ModTools;
import com.thallium.sdvm.registry.ModTrinkets;
import com.thallium.sdvm.util.cca.MyComponents;
import com.thallium.sdvm.util.networking.CurrencyUtils;
import dev.onyxstudios.cca.api.v3.component.ComponentProvider;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;

public class MarlonGuiDescription extends SyncedGuiDescription
{
    public MarlonGuiDescription(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        super(ModScreens.MARLON_SHOP, syncId, playerInventory);

        // Sell List
        WBuyButton woodenBlade = new WBuyButton(new ItemIcon(new ItemStack(ModTools.WOODEN_BLADE)), new LiteralText("Wooden Blade"), 250);
        woodenBlade.setOnClick(() -> { CurrencyUtils.purchase(new ItemStack(ModTools.WOODEN_BLADE), 250, MyComponents.MONEY.get(player).getMoney());});

        WBuyButton silverSaber = new WBuyButton(new ItemIcon(new ItemStack(ModTools.SILVER_SABER)), new LiteralText("Silver Saber"), 750);
        silverSaber.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.SILVER_SABER)); });

        WBuyButton pirateSword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.PIRATES_SWORD)), new LiteralText("Pirate's Sword"), 850);
        pirateSword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.PIRATES_SWORD)); });

        WBuyButton cutlass = new WBuyButton(new ItemIcon(new ItemStack(ModTools.CUTLASS)), new LiteralText("Cutlass"), 1500);
        cutlass.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.CUTLASS)); });

        WBuyButton claymore = new WBuyButton(new ItemIcon(new ItemStack(ModTools.CLAYMORE)), new LiteralText("Claymore"), 2000);
        claymore.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.CLAYMORE)); });

        WBuyButton templarsBlade = new WBuyButton(new ItemIcon(new ItemStack(ModTools.TEMPLARS_BLADE)), new LiteralText("Templar's Blade"), 4000);
        templarsBlade.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.TEMPLARS_BLADE)); });

        WBuyButton boneSword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.BONE_SWORD)), new LiteralText("Bone Sword"), 6000);
        boneSword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.BONE_SWORD)); });

        WBuyButton steelFalchion = new WBuyButton(new ItemIcon(new ItemStack(ModTools.STEEL_FALCHION)), new LiteralText("Steel Falchion"), 9000);
        steelFalchion.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.STEEL_FALCHION)); });

        WBuyButton lavaKatana = new WBuyButton(new ItemIcon(new ItemStack(ModTools.LAVA_KATANA)), new LiteralText("Lava Katana"), 25000);
        lavaKatana.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.LAVA_KATANA)); });

        WBuyButton galaxySword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.GALAXY_SWORD)), new LiteralText("Galaxy Sword"), 50000);
        galaxySword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.GALAXY_SWORD)); });

        WBuyButton rubyRing = new WBuyButton(new ItemIcon(new ItemStack(ModTrinkets.rubyRing)), new LiteralText("Ruby Ring"), 5000);
        rubyRing.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTrinkets.rubyRing)); });

        // LibGui Info
        WShopPanel root = new WShopPanel();
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
