package com.thallium.sdvm.items.combat;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ClubMaterials implements ToolMaterial
{
    FEMUR(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    WOOD_CLUB(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    WOOD_MALLET(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    LEAD_ROD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    KUDGEL(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    THE_SLAMMER(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    GALAXY_HAMMER(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    DWARF_HAMMER(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    DRAGONTOOTH_SHIV(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    INFINITY_GAVEL(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ClubMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient)
    {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
