package com.thallium.sdvm.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.thallium.sdvm.util.cca.MyComponents;
import io.github.cottonmc.cotton.gui.widget.WDynamicLabel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.Random;

@Environment(EnvType.CLIENT)
public class StardewHud extends WWidget
{
    private static final Identifier CLOCK_HUD_LOCATION = new Identifier("sdvm", "textures/gui/clock_hud_rect.png");
    public static final ItemStack universalClock = new ItemStack(Items.CLOCK);
    public static final Random theySeeMeRollin = new Random();

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        MinecraftClient mc = MinecraftClient.getInstance();
        mc.getTextureManager().bindTexture(CLOCK_HUD_LOCATION);
        RenderSystem.enableBlend();

        int width = mc.getWindow().getScaledWidth();
        int height = mc.getWindow().getScaledHeight();

        matrices.push();
        matrices.scale(1F, 1F, 1F);

        Tuple<Integer, Integer> truePos = IntegratedPreset.TOP_RIGHT.calculatePosition(width, height);

        mc.inGameHud.drawTexture(matrices, truePos.getA(), truePos.getB(), 0, 0, 66, 76);

        matrices.pop();
        matrices.push();
        matrices.scale(1F, 1F, 1F);

        //Time Configuration
        long time = mc.world.getTimeOfDay();

        if (time > 24000) time = time - 24000 * (int) (time / 24000);
        int hour, minute;

        if ((((int)time / 1000) + 6) > 23) hour = (((int)time/1000) + 6) - 24;
        else hour = (((int)time / 1000) + 6);

        if (((time * 60) / 1000) > 60) minute = (int)((time * 60) / 1000) - (60 * ((int)time / 1000));
        else minute = (int)((time * 60) / 1000);

        TextRenderer textRenderer = mc.textRenderer;

        String timeDisplay = hour + ":" + minute;

        //Money Configuration
        //String currencyDisplay = new Currency().getMoney().toString();
        int money = MyComponents.MONEY.get(mc.player).getValue();
        WDynamicLabel label = new WDynamicLabel(() -> String.valueOf(money));

        if (MinecraftClient.getInstance().world.getRegistryKey() == SuperPositionHandler.getNetherKey() || MinecraftClient.getInstance().world.getRegistryKey() == SuperPositionHandler.getEndKey())
        {
            String alt_text = "";

            for (int i = 0; i < timeDisplay.length(); i++)
            {
                alt_text = alt_text.concat(Character.isDigit(timeDisplay.charAt(i)) ? "" + theySeeMeRollin.nextInt(10) : "" + timeDisplay.charAt(i));
            }
            timeDisplay = alt_text;
        }
            mc.getItemRenderer().renderGuiItemIcon(universalClock, truePos.getA() + 6, truePos.getB() + 36);

            textRenderer.draw(matrices, timeDisplay, truePos.getA() + 27, truePos.getB() + 41, 2232610);
            //textRenderer.draw(matrices, money, truePos.getA() + 27, truePos.getB() + 65, 2232610);
            label.paint(matrices, truePos.getA() + 28, truePos.getB() + 64, 1, 1);

            matrices.pop();

            RenderSystem.disableBlend();
            mc.getTextureManager().bindTexture(DrawableHelper.GUI_ICONS_TEXTURE);
    }
}
