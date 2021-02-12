package com.thallium.sdvm.util.cca;

import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;

public interface IMoneyComponent extends ComponentV3
{
    int getValue();
    void incrementValue();
    void setValue(int amount);
}
