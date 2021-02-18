package com.thallium.sdvm.gui.widgets;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.icon.Icon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class WBuyButton extends WWidget
{
    private Text name;
    private Text price;
    private boolean enabled = true;
    protected HorizontalAlignment alignment;
    @Nullable
    private Runnable onClick;
    @Nullable
    private io.github.cottonmc.cotton.gui.widget.icon.Icon icon;
    private static final Identifier shopButton = new Identifier("sdvm", "textures/gui/shop_button.png");

    public WBuyButton(Icon icon, Text label, Text price)
    {
        this.alignment = HorizontalAlignment.CENTER;
        this.icon = null;
        this.icon = icon;
        this.name = label;
        this.price = price;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        boolean hovered = mouseX >= 0 && mouseY >= 0 && mouseX < this.getWidth() && mouseY < this.getHeight();
        int state = 1;
        if (!this.enabled) {
            state = 0;
        } else if (hovered || this.isFocused()) {
            state = 2;
        }

        ScreenDrawing.texturedRect(x, y, 252, 25, shopButton, 0xFFFFFFFF);

        if (this.icon != null)
        {
            this.icon.paint(matrices, x + 6, y + 6, 13);
        }

        if (this.name != null)
        {
            WLabel name = new WLabel(this.name);
            name.paint(matrices, x+25, y+9, 0, 0);
        }

        if (this.price != null)
        {
            WLabel price = new WLabel(this.price);
            price.paint(matrices, x+209, y+9, 0, 0);
        }
    }

    @Override
    public boolean canResize()
    {
        return false;
    }

    @Override
    public boolean canFocus()
    {
        return true;
    }

    @Environment(EnvType.CLIENT)
    @Override
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

    public WBuyButton setOnClick(@Nullable Runnable onClick)
    {
        this.onClick = onClick;
        return this;
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }


    public WBuyButton setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Text getName()
    {
        return this.name;
    }

    public Text getPrice()
    {
        return this.price;
    }

    public WBuyButton setName(Text name) {
        this.name = name;
        return this;
    }

    public WBuyButton setPrice(Text price)
    {
        this.price = price;
        return this;
    }

    public HorizontalAlignment getAlignment()
    {
        return this.alignment;
    }

    public WBuyButton setAlignment(HorizontalAlignment alignment) {
        this.alignment = alignment;
        return this;
    }

    @Nullable
    public Icon getIcon() {
        return this.icon;
    }

    public WBuyButton setIcon(Icon icon)
    {
        this.icon = icon;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WBuyButton buyWidget = (WBuyButton) o;
        return enabled == buyWidget.enabled &&
                Objects.equals(name, buyWidget.name) &&
                Objects.equals(price, buyWidget.price) &&
                alignment == buyWidget.alignment &&
                Objects.equals(onClick, buyWidget.onClick) &&
                Objects.equals(icon, buyWidget.icon);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, price, enabled, alignment, onClick, icon);
    }
}
