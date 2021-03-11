package com.thallium.sdvm.util.cca;

import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.util.cca.date.DateComponent;
import com.thallium.sdvm.util.cca.date.IDateComponent;
import com.thallium.sdvm.util.cca.money.IMoneyComponent;
import com.thallium.sdvm.util.cca.money.MoneyComponent;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.level.LevelComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.level.LevelComponentInitializer;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import nerdhub.cardinal.components.api.util.RespawnCopyStrategy;
import net.minecraft.util.Identifier;

public final class MyComponents implements EntityComponentInitializer, LevelComponentInitializer
{
    public static final ComponentKey<IMoneyComponent> MONEY = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(StardewValley.Mod_ID, "money"), IMoneyComponent.class);

    public static final ComponentKey<IDateComponent> DATE = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(StardewValley.Mod_ID, "date"), IDateComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry eRegistry)
    {
        eRegistry.registerForPlayers(MONEY, MoneyComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
    }

    @Override
    public void registerLevelComponentFactories(LevelComponentFactoryRegistry lRegistry)
    {
        lRegistry.register(DATE, DateComponent::new);
    }
}
