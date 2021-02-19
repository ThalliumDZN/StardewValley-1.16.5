package com.thallium.sdvm.gui.entity.marlon;

import com.thallium.sdvm.gui.widgets.WBuyButton;
import com.thallium.sdvm.registry.ModTools;
import com.thallium.sdvm.registry.ModTrinkets;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;

public class MarlonSellList
{
    /*
        MarlonSellList was never completed or used

        Although I would recommend eventually implementing this to clean up code
    */

    public void registerSellList(PlayerInventory playerInventory)
    {
        WBuyButton woodenBlade = new WBuyButton(new ItemIcon(new ItemStack(ModTools.WOODEN_BLADE)), new LiteralText("Wooden Blade"), 5);
        woodenBlade.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.WOODEN_BLADE)); });

        WBuyButton silverSaber = new WBuyButton(new ItemIcon(new ItemStack(ModTools.SILVER_SABER)), new LiteralText("Silver Saber"), 5);
        silverSaber.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.SILVER_SABER)); });

        WBuyButton pirateSword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.PIRATES_SWORD)), new LiteralText("Pirate's Sword"), 5);
        pirateSword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.PIRATES_SWORD)); });

        WBuyButton cutlass = new WBuyButton(new ItemIcon(new ItemStack(ModTools.CUTLASS)), new LiteralText("Cutlass"), 5);
        cutlass.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.CUTLASS)); });

        WBuyButton claymore = new WBuyButton(new ItemIcon(new ItemStack(ModTools.CLAYMORE)), new LiteralText("Claymore"), 5);
        claymore.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.CLAYMORE)); });

        WBuyButton templarsBlade = new WBuyButton(new ItemIcon(new ItemStack(ModTools.TEMPLARS_BLADE)), new LiteralText("Templar's Blade"), 5);
        templarsBlade.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.TEMPLARS_BLADE)); });

        WBuyButton boneSword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.BONE_SWORD)), new LiteralText("Bone Sword"), 5);
        boneSword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.BONE_SWORD)); });

        WBuyButton steelFalchion = new WBuyButton(new ItemIcon(new ItemStack(ModTools.STEEL_FALCHION)), new LiteralText("Steel Falchion"), 5);
        steelFalchion.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.STEEL_FALCHION)); });

        WBuyButton lavaKatana = new WBuyButton(new ItemIcon(new ItemStack(ModTools.LAVA_KATANA)), new LiteralText("Lava Katana"), 5);
        lavaKatana.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.LAVA_KATANA)); });

        WBuyButton galaxySword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.GALAXY_SWORD)), new LiteralText("Galaxy Sword"), 5);
        galaxySword.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTools.GALAXY_SWORD)); });

        WBuyButton rubyRing = new WBuyButton(new ItemIcon(new ItemStack(ModTrinkets.rubyRing)), new LiteralText("Ruby Ring"), 5);
        rubyRing.setOnClick(() -> { playerInventory.insertStack(new ItemStack(ModTrinkets.rubyRing)); });
    }

}
