package com.thallium.sdvm.mixin;

import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen extends Screen
{
    private static final WLabel label1 = new WLabel("WARNING");
    private static final WLabel label2 = new WLabel("SDV IS A STANDALONE MOD, USE OTHER MODS WITH EXTREME CAUTION");

    protected MixinTitleScreen(Text title)
    {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "render")
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci)
    {
        label1.paint(matrices, this.width / 2 - 5, 5, 0, 0);
        label1.setHorizontalAlignment(HorizontalAlignment.CENTER);
        label1.setColor(0xff0000);

        label2.paint(matrices, this.width / 2 - 5, 15, 0, 0);
        label2.setHorizontalAlignment(HorizontalAlignment.CENTER);
        label2.setColor(0xff0000);
    }
}
