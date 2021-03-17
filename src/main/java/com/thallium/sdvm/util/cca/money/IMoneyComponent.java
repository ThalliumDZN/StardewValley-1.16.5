package com.thallium.sdvm.util.cca.money;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface IMoneyComponent extends ComponentV3
{
    int getMoney();
    boolean isNegativeMoney();
    void addMoney(int amount);
    void subtractMoney(int amount);
    void multiplyMoney(int amount);
    void divideMoney(int amount);
    void setMoney(int amount);
    void resetMoney();

    void purchase(ItemStack item, int cost);
    void sell();
}
