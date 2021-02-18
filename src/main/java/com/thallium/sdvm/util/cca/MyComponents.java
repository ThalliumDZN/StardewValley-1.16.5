package com.thallium.sdvm.util.cca;

import com.thallium.sdvm.StardewValley;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.minecraft.util.Identifier;

public final class MyComponents implements EntityComponentInitializer
{
    public static final ComponentKey<IMoneyComponent> MONEY =
            ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(StardewValley.Mod_ID, "money"), IMoneyComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry)
    {
        registry.registerForPlayers(MONEY, MoneyComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}
