package com.thallium.sdvm.util.cca.friendship;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.nbt.CompoundTag;

public interface IFriendshipComponent extends ComponentV3
{
    int getAmount();

    boolean isMaxAmount();

    void addAmount();
    void subtractAmount();
}
