package com.thallium.sdvm.gui.widgets.fishing;

import com.thallium.sdvm.gui.fishing.FishingGui;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.util.Identifier;

import java.util.Random;

public class WFishingIcon extends WSprite
{
    public static final Identifier ID = new Identifier("sdvm", "textures/gui/fishing/fish.png");
    public static final Texture TEXTURE = new Texture(ID);

    private int y_speed = 2;
    private int x_pos = -139;
    private int y_pos = 36;
    private final int x_icon = 13;
    private final int y_icon = 14;

    public WFishingIcon(Texture texture)
    {
        super(texture);
    }

    @Override
    public int getX()
    {
        return x_pos;
    }

    @Override
    public int getY()
    {
        return y_pos;
    }

    public void move()
    {
        y_pos += y_speed;
    }

    @Override
    public void tick()
    {
        super.tick();
    }
}
