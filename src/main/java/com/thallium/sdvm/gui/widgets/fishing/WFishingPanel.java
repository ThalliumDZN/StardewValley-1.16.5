package com.thallium.sdvm.gui.widgets.fishing;

import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WFishingPanel extends WPlainPanel
{
    private static final Identifier TEXTURE = new Identifier("sdvm", "textures/gui/fishing/background.png");
    private final WSprite bg = new WSprite(TEXTURE);

    public WFishingPanel()
    {
        bg.setParent(this);
        add(bg, -155, 0, 36, 148);
    }

    @Override
    public void tick()
    {
        super.tick();
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        super.paint(matrices, x, y, mouseX, mouseY);
    }
}
