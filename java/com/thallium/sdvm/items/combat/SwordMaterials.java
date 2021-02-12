package com.thallium.sdvm.items.combat;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum SwordMaterials implements ToolMaterial
{
    RUSTY_SWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    STEEL_SMALLSWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    WOODEN_BLADE(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    PIRATES_SWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    SILVER_SABER(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    CUTLASS(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    FOREST_SWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    IRON_EDGE(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    INSECT_HEAD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    BONE_SWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    CLAYMORE(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    NEPTUNES_GLAIVE(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    TEMPLARS_BLADE(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    OBSIDIAN_EDGE(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    OSSIFIED_BLADE(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    TEMPERED_BROADSWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    YETI_TOOTH(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    STEEL_FALCHION(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    DARK_SWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    LAVA_KATANA(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    DRAGONTOOTH_CUTLASS(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    DWARF_SWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    GALAXY_SWORD(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); }),
    INFINITY_BLADE(0, 59, 2.0F, 8.0F, 15, ()->{ return Ingredient.ofItems(Items.BONE); });


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private SwordMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient)
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
