package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.items.rings.RubyRing;
import com.thallium.sdvm.items.rings.SmallMagnetRing;
import com.thallium.sdvm.items.rings.util.RingMaterial;
import com.thallium.sdvm.items.rings.MagnetRing;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketSlots;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTrinkets
{
    public static final RingMaterial magnetRing = new MagnetRing("magnet_ring", "tooltip.sdvm.magnet_ring");
    public static final RingMaterial smallMagnetRing = new SmallMagnetRing("small_magnet_ring", "tooltip.sdvm.small_magnet_ring");
    public static final RingMaterial rubyRing = new RubyRing("ruby_ring", "tooltip.sdvm.ruby_ring");

    public static void registerTrinkets() {
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "magnet_ring"), magnetRing);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "small_magnet_ring"), smallMagnetRing);
        Registry.register(Registry.ITEM, new Identifier(StardewValley.Mod_ID, "ruby_ring"), rubyRing);

        TrinketSlots.addSlot(SlotGroups.HAND, Slots.RING, new Identifier("trinkets", "textures/item/empty_trinket_slot_ring.png"));
        TrinketSlots.addSlot(SlotGroups.HEAD, Slots.MASK, new Identifier("trinkets", "textures/item/empty_trinket_slot_mask.png"));
    }
}
