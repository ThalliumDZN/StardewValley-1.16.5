package com.thallium.sdvm.gui.widgets;

import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WShopPanel extends WPlainPanel
{
    private static final Identifier shopPanel = new Identifier("sdvm", "textures/gui/shop_panel.png");
    private final WSprite bg = new WSprite(shopPanel);

    public WShopPanel()
    {
        bg.setParent(this);
        add(bg, 0, 0, 260, 105);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        super.paint(matrices, x, y, mouseX, mouseY);
    }
}
