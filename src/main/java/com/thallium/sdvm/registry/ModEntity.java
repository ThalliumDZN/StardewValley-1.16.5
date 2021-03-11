package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.blocks.currency_book.CurrencyBookBlock;
import com.thallium.sdvm.blocks.currency_book.CurrencyBookBlockEntity;
import com.thallium.sdvm.blocks.selling_block.SellingBlockEntity;
import com.thallium.sdvm.blocks.vendor.VendingBlock;
import com.thallium.sdvm.blocks.vendor.VendingBlockEntity;
import com.thallium.sdvm.entity.villagers.clint.ClintEntity;
import com.thallium.sdvm.entity.villagers.marlon.MarlonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.object.builder.FabricEntityType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntity
{
    public static EntityType<MarlonEntity> CUBE;
    public static EntityType<ClintEntity> CLINT;

    public static BlockEntityType<CurrencyBookBlockEntity> CURRENCY_BOOK;
    public static BlockEntityType<SellingBlockEntity> SELLING_BLOCK_ENTITY;

    public static void registerEntity()
    {
        //Block Entity
        VendingBlockEntity.TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(StardewValley.Mod_ID, "vending_block"), BlockEntityType.Builder.create(VendingBlockEntity::new, VendingBlock.INSTANCE).build(null));
        CurrencyBookBlockEntity.TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(StardewValley.Mod_ID, "currency_book"), BlockEntityType.Builder.create(CurrencyBookBlockEntity::new, CurrencyBookBlock.INSTANCE).build(null));
        SELLING_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(StardewValley.Mod_ID, "selling_block"), BlockEntityType.Builder.create(SellingBlockEntity::new, ModBlocks.SELL_BLOCK).build(null));

        //Villagers
        CUBE = Registry.register(Registry.ENTITY_TYPE, new Identifier("sdvm", "cube"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MarlonEntity::new).dimensions(EntityDimensions.fixed(1f, 1.8f)).build());
        CLINT = Registry.register(Registry.ENTITY_TYPE, new Identifier("sdvm", "clint"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ClintEntity::new).dimensions(EntityDimensions.fixed(1f, 1.8f)).build());

        //Adding Villager Attributes
        FabricDefaultAttributeRegistry.register(CUBE, MarlonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CLINT, ClintEntity.createMobAttributes());
    }
}
