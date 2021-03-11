package com.thallium.sdvm.gui.entity.marlon;

import com.thallium.sdvm.gui.widgets.WBuyButton;
import com.thallium.sdvm.registry.ModTools;
import com.thallium.sdvm.registry.ModTrinkets;
import com.thallium.sdvm.util.networking.money.CurrencyUtils;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;

public class MarlonSellList
{
    public static WBuyButton woodenBlade = new WBuyButton(new ItemIcon(new ItemStack(ModTools.WOODEN_BLADE)), new LiteralText("Wooden Blade"), 250);
    public static WBuyButton silverSaber = new WBuyButton(new ItemIcon(new ItemStack(ModTools.SILVER_SABER)), new LiteralText("Silver Saber"), 750);
    public static WBuyButton pirateSword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.PIRATES_SWORD)), new LiteralText("Pirate's Sword"), 850);
    public static WBuyButton cutlass = new WBuyButton(new ItemIcon(new ItemStack(ModTools.CUTLASS)), new LiteralText("Cutlass"), 1500);
    public static WBuyButton claymore = new WBuyButton(new ItemIcon(new ItemStack(ModTools.CLAYMORE)), new LiteralText("Claymore"), 2000);
    public static WBuyButton templarsBlade = new WBuyButton(new ItemIcon(new ItemStack(ModTools.TEMPLARS_BLADE)), new LiteralText("Templar's Blade"), 4000);
    public static WBuyButton boneSword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.BONE_SWORD)), new LiteralText("Bone Sword"), 6000);
    public static WBuyButton steelFalchion = new WBuyButton(new ItemIcon(new ItemStack(ModTools.STEEL_FALCHION)), new LiteralText("Steel Falchion"), 9000);
    public static WBuyButton lavaKatana = new WBuyButton(new ItemIcon(new ItemStack(ModTools.LAVA_KATANA)), new LiteralText("Lava Katana"), 25000);
    public static WBuyButton galaxySword = new WBuyButton(new ItemIcon(new ItemStack(ModTools.GALAXY_SWORD)), new LiteralText("Galaxy Sword"), 50000);
    public static WBuyButton rubyRing = new WBuyButton(new ItemIcon(new ItemStack(ModTrinkets.rubyRing)), new LiteralText("Ruby Ring"), 5000);

    static void registerSellList()
    {
        woodenBlade.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.WOODEN_BLADE), woodenBlade.costPer));
        silverSaber.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.SILVER_SABER), silverSaber.costPer));
        pirateSword.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.PIRATES_SWORD), pirateSword.costPer));
        cutlass.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.CUTLASS), cutlass.costPer));
        claymore.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.CLAYMORE), claymore.costPer));
        templarsBlade.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.TEMPLARS_BLADE), templarsBlade.costPer));
        boneSword.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.BONE_SWORD), boneSword.costPer));
        steelFalchion.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.STEEL_FALCHION), steelFalchion.costPer));
        lavaKatana.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.LAVA_KATANA), lavaKatana.costPer));
        galaxySword.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTools.GALAXY_SWORD), galaxySword.costPer));
        rubyRing.setOnClick(() -> CurrencyUtils.purchase(new ItemStack(ModTrinkets.rubyRing), rubyRing.costPer));
    }

}
