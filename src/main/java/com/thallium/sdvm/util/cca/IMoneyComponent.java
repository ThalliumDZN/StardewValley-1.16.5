package com.thallium.sdvm.util.cca;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;

public interface IMoneyComponent extends ComponentV3
{
    int getValue();
    void setValue(int amount);
    void addMoney(int amount);
}
