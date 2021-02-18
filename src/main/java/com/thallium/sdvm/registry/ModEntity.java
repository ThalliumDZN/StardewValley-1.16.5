package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.blocks.vendor.VendingBlock;
import com.thallium.sdvm.blocks.vendor.VendingBlockEntity;
import com.thallium.sdvm.entity.villagers.clint.ClintEntity;
import com.thallium.sdvm.entity.villagers.marlon.MarlonEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
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

    public static void registerEntity()
    {
        VendingBlockEntity.TYPE = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(StardewValley.Mod_ID, "vending_block"), BlockEntityType.Builder.create(VendingBlockEntity::new, VendingBlock.INSTANCE).build(null));

        //Villagers
        CUBE = Registry.register(Registry.ENTITY_TYPE, new Identifier("sdvm", "cube"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MarlonEntity::new).dimensions(EntityDimensions.fixed(1f, 1.8f)).build());
        CLINT = Registry.register(Registry.ENTITY_TYPE, new Identifier("sdvm", "clint"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ClintEntity::new).dimensions(EntityDimensions.fixed(1f, 1.8f)).build());

        //Adding Villager Attributes
        FabricDefaultAttributeRegistry.register(CUBE, MarlonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CLINT, ClintEntity.createMobAttributes());
    }
}
