package com.thallium.sdvm.gui.widgets.friendship;

import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class WFriendshipInfo extends WPlainPanel
{
    private static final Identifier TEXTURE = new Identifier("sdvm", "textures/gui/friendship/friendship_info.png");
    private static final WSprite bg = new WSprite(TEXTURE);
    protected HorizontalAlignment alignment;

    public Text name;
    private WSprite sprite;

    public WFriendshipInfo(WSprite sprite, Text name)
    {
        bg.setParent(this);
        add(bg, 0, 0, 208, 29);
        this.alignment = HorizontalAlignment.CENTER;
        this.sprite = sprite;
        this.name = name;
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        super.paint(matrices, x, y, mouseX, mouseY);

        this.sprite.paint(matrices, x+5, y+10, mouseX, mouseY);

        WLabel wName = new WLabel(this.name);
        wName.setHorizontalAlignment(HorizontalAlignment.CENTER);
        wName.paint(matrices, x+35, y+11, mouseX, mouseY);
    }

    @Override
    public boolean canResize() {
        return false;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WFriendshipInfo widget = (WFriendshipInfo) o;
        return alignment == widget.alignment && Objects.equals(sprite, widget.sprite) && Objects.equals(name, widget.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(alignment, sprite, name);
    }
}
