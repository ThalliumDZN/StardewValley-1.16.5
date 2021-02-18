package com.thallium.sdvm.gui.calendar;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CalendarGui extends LightweightGuiDescription
{
    private static final Identifier SPRING = new Identifier("sdvm", "textures/gui/calendar_spring.png");

    @Environment(EnvType.CLIENT)
    public void paint(MatrixStack matrices)
    {
        //ScreenDrawing.texturedRect(0, 0, 240, 168, SPRING, 0xFFFFFFFF);

        WSprite calender = new WSprite(new Identifier("sdvm:textures/gui/calendar_spring.png"));
        calender.paint(matrices, 1, 1, 0, 0);
    }
}
