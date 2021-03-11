package com.thallium.sdvm.gui.calendar.fall;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FallCalendarGui extends LightweightGuiDescription
{
    private static final Identifier season = new Identifier("sdvm", "textures/gui/calendar_fall.png");
    private final WSprite bg = new WSprite(season);
    private MatrixStack matrixStack;

    @Environment(EnvType.CLIENT)
    public void paint(MatrixStack matrices)
    {
        bg.paint(matrices, 0, 0, 0, 0);
    }

    @Override
    public void addPainters()
    {
        bg.paint(matrixStack, 0, 0, 0, 0);
    }
}
