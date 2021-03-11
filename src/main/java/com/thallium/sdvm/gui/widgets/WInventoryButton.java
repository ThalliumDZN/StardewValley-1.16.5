package com.thallium.sdvm.gui.widgets;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.icon.Icon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class WInventoryButton extends WWidget
{
    private static final Identifier texture = new Identifier("sdvm", "textures/gui/friendship_texture.png");
    private io.github.cottonmc.cotton.gui.widget.icon.Icon icon;
    private boolean enabled = true;
    private HorizontalAlignment alignment;
    @Nullable
    private Runnable onClick;
    public PlayerEntity player;

    public WInventoryButton(Icon icon)
    {
        this.alignment = HorizontalAlignment.CENTER;
        this.icon = null;
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        if (this.enabled)
        {
            ScreenDrawing.texturedRect(x, y, 20, 20, texture, 0xFFFFFFFF);
        }

        if (this.icon != null)
        {
            this.icon.paint(matrices, x+6, y+6, 13);
        }

        super.paint(matrices, x, y, mouseX, mouseY);
    }

    @Override
    public boolean canResize() {
        return false;
    }

    @Override
    public boolean canFocus() {
        return true;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void onClick(int x, int y, int button)
    {
        super.onClick(x, y, button);
        if (this.enabled && this.isWithinBounds(x, y)) {
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
            if (this.onClick != null)
            {
                this.onClick.run();
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onKeyPressed(int ch, int key, int modifiers)
    {
        if (isActivationKey(ch)) {
            this.onClick(0, 0, 0);
        }
    }

    @Nullable
    public Runnable getOnClick()
    {
        return this.onClick;
    }

    public WInventoryButton setOnClick()
    {
        this.onClick = onClick;
        return this;
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }

    public WInventoryButton setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public WInventoryButton setAlignment(HorizontalAlignment alignment) {
        this.alignment = alignment;
        return this;
    }

    @Nullable
    public Icon getIcon() {
        return this.icon;
    }

    public WInventoryButton setIcon(Icon icon)
    {
        this.icon = icon;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WInventoryButton ib = (WInventoryButton) o;
        return enabled == ib.enabled &&
                alignment == ib.alignment &&
                Objects.equals(onClick, ib.onClick) &&
                Objects.equals(icon, ib.icon);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(enabled, alignment, onClick, icon);
    }
}
