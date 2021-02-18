package com.thallium.sdvm.gui.widgets;

import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WQuestionPanel extends WPlainPanel
{
    private static final Identifier questionPanel = new Identifier("sdvm", "textures/gui/question_panel.png");
    private final WSprite bg = new WSprite(questionPanel);

    public WQuestionPanel()
    {
        bg.setParent(this);
        add(bg, 0, 0, 224, 76);
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        super.paint(matrices, x, y, mouseX, mouseY);
    }
}
