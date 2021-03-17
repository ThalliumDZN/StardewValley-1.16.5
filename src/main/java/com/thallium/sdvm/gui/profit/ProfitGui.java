package com.thallium.sdvm.gui.profit;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class ProfitGui extends LightweightGuiDescription
{

    /*
        the gui that is displayed when you wake up
    */

    private static final Identifier season = new Identifier("sdvm", "textures/gui/calendar_fall.png");
    MinecraftClient MC = MinecraftClient.getInstance();

    @Environment(EnvType.CLIENT)
    public void paint(MatrixStack matrices)
    {
        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);

        root.setSize(200, 125);
        root.paint(matrices, MC.getWindow().getWidth() / 2, MC.getWindow().getHeight() / 2, 0, 0);

        WButton b = new WButton();
        root.add(b, root.getWidth() / 2, root.getHeight() / 2);
        b.setLabel(new TranslatableText("next day"));
        b.setOnClick(() ->
        {
           MC.player.closeScreen();
        });
    }
}
