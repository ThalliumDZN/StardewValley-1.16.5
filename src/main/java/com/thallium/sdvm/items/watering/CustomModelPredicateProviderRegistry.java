package com.thallium.sdvm.items.watering;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.util.Arm;

public class CustomModelPredicateProviderRegistry
{
    public static void register() {

        FabricModelPredicateProviderRegistry.register(WateringUtils.ID("water_level"),
                (itemStack, clientWorld, livingEntity) -> {
                    if (livingEntity == null || livingEntity.getMainArm() != Arm.RIGHT) {
                        return 0f;
                    }
                    return !itemStack.isEmpty() && itemStack.getItem() instanceof WateringCan && WateringCan.isFilled(itemStack) ? 1F : 0F;
                }
        );

    }
}
