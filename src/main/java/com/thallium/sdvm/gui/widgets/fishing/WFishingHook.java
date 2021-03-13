package com.thallium.sdvm.gui.widgets.fishing;

import com.thallium.sdvm.gui.fishing.FishingGui;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.util.Identifier;

public class WFishingHook extends WSprite
{
    public static int y_speed = 1;
    private int x = -139;
    private int y = 36;

    private static final int max_X = 9;
    private static final int max_Y = 149;

    private boolean isMouseDown;

    public static final Identifier ID = new Identifier("sdvm", "textures/gui/fishing/green_bar.png");
    public static final Texture TEXTURE = new Texture(ID);

    public WFishingHook(Texture texture)
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
        return onMouseUp(x, y, button);
    }

    @Override
    public WWidget onMouseDown(int x, int y, int button)
    {
        isMouseDown = true;
        return onMouseDown(x, y, button);
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

    public void move()
    {
        if (tCollision())
        {
            y_speed = 1;
        }
        if (bCollision())
        {
            y_speed = -1;
        }

        y += y_speed;
    }

    public boolean tCollision()
    {
        return this.getY() == FishingGui.bBorder.getY();
    }

    public boolean bCollision()
    {
        return this.getY() == FishingGui.tBorder.getY();
    }

    @Override
    public void tick()
    {
        super.tick();

        if (isMouseDown == true)
        {
            //move widget upwards
            y_speed = -1;
            move();
        } else if (isMouseDown == false)
        {
            //move widget downwards
            y_speed = 1;
            move();
        }
    }
}
