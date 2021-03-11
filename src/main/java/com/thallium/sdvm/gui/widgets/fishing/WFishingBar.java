package com.thallium.sdvm.gui.widgets.fishing;

import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.util.Identifier;

public class WFishingBar extends WSprite
{
    private int y_speed;
    private int x = -139;
    private int y = 36;

    private boolean isMouseDown;

    public static final Identifier ID = new Identifier("sdvm", "textures/gui/fishing/green_bar.png");
    public static final Texture TEXTURE = new Texture(ID);

    public WFishingBar(Texture texture)
    {
        super(texture);
        requestFocus();
    }

    @Override
    public boolean canFocus()
    {
        return true;
    }

    @Override
    public WWidget onMouseUp(int x, int y, int button)
    {
        isMouseDown = false;
        return super.onMouseUp(x, y, button);
    }

    @Override
    public WWidget onMouseDown(int x, int y, int button)
    {
        isMouseDown = true;
        return super.onMouseDown(x, y, button);
    }

    @Override
    public int getX()
    {
        return x;
    }
    @Override
    public int getY()
    {
        return y;
    }

    public static Texture getTEXTURE()
    {
        return TEXTURE;
    }

    public void move()
    {
        y += y_speed;
    }

    @Override
    public void tick()
    {
        if (isMouseDown)
        {
            //move widget upwards
            y_speed = -2;
            move();
        } else
        {
            //move widget downwards
            y_speed = 2;
            move();
        }

        super.tick();
    }
}
