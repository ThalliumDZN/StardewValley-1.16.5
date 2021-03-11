package com.thallium.sdvm.gui.widgets;

import com.thallium.sdvm.util.networking.money.CurrencyUtils;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class WClearButton extends WWidget
{
    private Text textField;
    private boolean enabled = true;
    protected HorizontalAlignment alignment;
    @Nullable
    private Runnable onClick;
    public PlayerEntity player;

    public WClearButton(Text textField)
    {
        this.alignment = HorizontalAlignment.LEFT;
        this.textField = textField;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        boolean hovered = mouseX >= 0 && mouseY >= 0 && mouseX < this.getWidth() && mouseY < this.getHeight();
        if (!this.enabled) {
        } else if (hovered || this.isFocused())
        {
        }

        if (this.textField != null)
        {
            WLabel textField = new WLabel(this.textField);
            textField.paint(matrices, x, y, 0, 0);
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

    @Override
    @Environment(EnvType.CLIENT)
    public void onClick(int x, int y, int button)
    {
        super.onClick(x, y, button);
        if (this.enabled && this.isWithinBounds(x, y))
        {
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
            if (this.onClick != null)
            {
                //Delete this later, was only added in v0.1 for testing reasons
                CurrencyUtils.addMoney(250);

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

    public WClearButton setOnClick(@Nullable Runnable onClick)
    {
        this.onClick = onClick;
        return this;
    }

    public boolean isEnabled()
    {
        return this.enabled;
    }

    public WClearButton setEnabled(boolean enabled)
    {
        this.enabled = enabled;
        return this;
    }

    public Text getTextField()
    {
        return this.textField;
    }

    public WClearButton setName(Text textField)
    {
        this.textField = textField;
        return this;
    }

    public HorizontalAlignment getAlignment()
    {
        return this.alignment;
    }

    public WClearButton setAlignment(HorizontalAlignment alignment) {
        this.alignment = alignment;
        return this;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WClearButton clearWidget = (WClearButton) o;
        return enabled == clearWidget.enabled &&
                Objects.equals(textField, clearWidget.textField) &&
                alignment == clearWidget.alignment &&
                Objects.equals(onClick, clearWidget.onClick);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(textField, enabled, alignment, onClick);
    }
}
