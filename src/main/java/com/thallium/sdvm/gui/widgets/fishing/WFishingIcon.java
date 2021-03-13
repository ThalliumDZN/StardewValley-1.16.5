package com.thallium.sdvm.gui.widgets.fishing;

import com.mojang.serialization.Dynamic;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.nbt.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.world.timer.Timer;
import net.minecraft.world.timer.TimerCallbackSerializer;

import java.util.Random;
import java.util.stream.Stream;

public class WFishingIcon extends WSprite
{
    public static final Identifier ID = new Identifier("sdvm", "textures/gui/fishing/fish.png");
    public static final Texture TEXTURE = new Texture(ID);

    private int y_speed = 0;
    private int x = -139;
    private int y = 36;
    private final int width = 13;
    private final int height = 14;
    private static final int maxWidth = 9;
    private static final int maxHeight = 149;

    private static int timer = 0;

    private static Random rnd = new Random();

    public WFishingIcon(Texture texture)
    {
        super(texture);
    }

    @Override
    public boolean canFocus() {
        return false;
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
        y += y_speed;
    }

    public void timer()
    {
        if (timer == rnd.nextInt(2- -2 + 1) + -2)
        {
            timer = 0;
            y_speed = rnd.nextInt(3 - -3 + 1) + -3;
        } else
        {
            move();
        }
    }

    @Override
    public void tick()
    {
        timer++;

        timer();
        move();

        super.tick();
    }
}
