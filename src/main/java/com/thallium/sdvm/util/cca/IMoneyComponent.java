package com.thallium.sdvm.util.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public interface IMoneyComponent extends ComponentV3
{
    int getValue();
    void incrementValue();
    void setValue(int amount);
}
