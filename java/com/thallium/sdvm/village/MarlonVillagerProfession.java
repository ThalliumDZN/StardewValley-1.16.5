package com.thallium.sdvm.village;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.registry.ModTools;
import com.thallium.sdvm.registry.ModTrinkets;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;

public class MarlonVillagerProfession
{
    public static final PointOfInterestType MARLON_PIT = PointOfInterestHelper.register(StardewValley.id("marlon_pit"), 1, 1, Blocks.LIGHT_GRAY_CARPET);

    public static final VillagerProfession MARLON = VillagerProfessionBuilder.create().id(StardewValley.id("marlon")).workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).workstation(MARLON_PIT).build();

    public static final List<Item> TRADES = Lists.newArrayList(
            ModTools.WOODEN_BLADE,
            ModTools.SILVER_SABER,
            ModTools.PIRATES_SWORD,
            ModTools.CUTLASS,
            ModTools.CLAYMORE,
            ModTools.TEMPLARS_BLADE,
            ModTools.BONE_SWORD,
            ModTools.STEEL_FALCHION,
            ModTools.LAVA_KATANA,
            ModTools.GALAXY_SWORD,
            ModTrinkets.rubyRing,
            ModTools.INSECT_HEAD);

    public static void init()
    {
        Registry.register(Registry.VILLAGER_PROFESSION, StardewValley.id("marlon"), MARLON);

        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(MARLON, new Int2ObjectOpenHashMap<>(ImmutableMap.of(
            1, new TradeOffers.Factory[]
                        {
                                //Swords For Sale
                                new BasicTradeFactory((e, r) -> i(ModTools.RUSTY_SWORD), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.SILVER_SABER), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.PIRATES_SWORD), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.CUTLASS), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.CLAYMORE), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.TEMPLARS_BLADE), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.BONE_SWORD), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.STEEL_FALCHION), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.LAVA_KATANA), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.GALAXY_SWORD), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTools.INSECT_HEAD), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),


                                //Rings For Sale
                                new BasicTradeFactory((e, r) -> i(ModTrinkets.rubyRing), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTrinkets.smallMagnetRing), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f),
                                new BasicTradeFactory((e, r) -> i(ModTrinkets.magnetRing), Optional.empty(), (e, r) -> i(Items.ACACIA_FENCE, 8 + r.nextInt(6)), 2, 5, 0.00f)
                        }
        )));
    }

    private static ItemStack i(ItemConvertible item) { return new ItemStack(item); }
    private static ItemStack i(ItemConvertible item, int count) { return new ItemStack(item, count); }


    public static class BasicTradeFactory implements TradeOffers.Factory
    {
        private final BiFunction<Entity, Random, ItemStack> stackA;
        private final Optional<BiFunction<Entity, Random, ItemStack>> stackB;
        private final BiFunction<Entity, Random, ItemStack> result;
        private final int maxUses;
        private final int experience;
        private final float priceMultiplier;

        public BasicTradeFactory(BiFunction<Entity, Random, ItemStack> stackA, Optional<BiFunction<Entity, Random, ItemStack>> stackB, BiFunction<Entity, Random, ItemStack> result, int maxUses, int experience, float priceMultiplier) {
            this.stackA = stackA; this.stackB = stackB; this.result = result; this.maxUses = maxUses; this.experience = experience; this.priceMultiplier = priceMultiplier;
        }

        public BasicTradeFactory(ItemStack stackA, ItemStack stackB, ItemStack result, int maxUses, int experience, float priceMultiplier) {
            this((e, r) -> stackA, Optional.of((e, r) -> stackB), (e, r) -> result, maxUses, experience, priceMultiplier);
        }

        public BasicTradeFactory(ItemStack stack, ItemStack result, int maxUses, int experience, float priceMultiplier) {
            this((e, r) -> stack, Optional.empty(), (e, r) -> result, maxUses, experience, priceMultiplier);
        }

        @Override
        public @Nullable TradeOffer create(Entity entity, Random random)
        {
            ItemStack b = ItemStack.EMPTY;
            if(stackB.isPresent()) b = stackB.get().apply(entity, random);
            return new TradeOffer(this.stackA.apply(entity, random), b, result.apply(entity, random), this.maxUses, this.experience, this.priceMultiplier);
        }
    }
}
