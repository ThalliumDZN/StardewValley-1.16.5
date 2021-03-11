package com.thallium.sdvm.util.cca.date;

import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.tick.ClientTickingComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;

public interface IDateComponent extends ComponentV3, ServerTickingComponent, ClientTickingComponent {
    int getDay();

    boolean isLastDay();
    boolean isFirstDay();
    boolean didAwake();

    void newDay(int amount);
    void setDay(int amount);
}
