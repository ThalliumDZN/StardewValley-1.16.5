package com.thallium.sdvm.items.rings.util;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.item.ItemGroup;

public class RingMaterial extends TrinketItem
{
    private String ringName;
    private String tooltip;

    public RingMaterial(String name, String tooltip) {
        super(new Settings().group(ItemGroup.TOOLS).maxCount(1));
        this.ringName = name;
        this.tooltip = tooltip;
    }

    @Override
    public boolean canWearInSlot(String group, String slot) {
        return group.equals(SlotGroups.HAND) && slot.equals(Slots.RING);
    }
}
