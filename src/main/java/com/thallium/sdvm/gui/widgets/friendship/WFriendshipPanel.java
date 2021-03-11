package com.thallium.sdvm.gui.widgets.friendship;

import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WFriendshipPanel extends WPlainPanel
{
    private static final Identifier TEXTURE = new Identifier("sdvm", "textures/gui/friendship_panel.png");
    private static final WSprite bg = new WSprite(TEXTURE, 0f, 0f, 214/256f, 147/256f);

    public WFriendshipPanel()
    {
        bg.setParent(this);
        add(bg, 0, 0, 214, 147);
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        super.paint(matrices, x, y, mouseX, mouseY);
    }

    @Override
    public boolean canResize()
    {
        return false;
    }
}
