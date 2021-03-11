package com.thallium.sdvm.gui.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import com.thallium.sdvm.StardewValley;
import com.thallium.sdvm.util.TimeUtil;
import com.thallium.sdvm.util.cca.MyComponents;
import com.thallium.sdvm.util.cca.date.IDateComponent;
import com.thallium.sdvm.util.seasons.Season;
import io.github.cottonmc.cotton.gui.widget.WDynamicLabel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Environment(EnvType.CLIENT)
public class StardewHud extends WWidget
{
    private static final Identifier HUD = new Identifier("sdvm", "textures/gui/clock_hud_rect.png");
    //public static final ItemStack universalClock = new ItemStack(Items.CLOCK);

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    {
        MinecraftClient mc = MinecraftClient.getInstance();
        World world = MinecraftClient.getInstance().world;

        mc.getTextureManager().bindTexture(HUD);
        RenderSystem.enableBlend();

        int width = mc.getWindow().getScaledWidth();
        int height = mc.getWindow().getScaledHeight();

        matrices.push();
        matrices.scale(1F, 1F, 1F);

        Tuple<Integer, Integer> truePos = IntegratedPreset.TOP_RIGHT.calculatePosition(width, height);

        mc.inGameHud.drawTexture(matrices, truePos.getA(), truePos.getB(), 0, 0, 66, 56);

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

        String timeDisplay = hour + ":" + minute;

        //SEASON FUNCTIONALITY
        String season = Season.getCurrentSeason().name().toLowerCase();
        WDynamicLabel seasonLabel = new WDynamicLabel(() -> season);
        seasonLabel.setAlignment(HorizontalAlignment.CENTER);

        //DAY FUNCTIONALITY
        if (world != null)
        {
            int seasonLength = Season.getSeasonLength();
            String day = Long.toString(((seasonLength - (world.getTimeOfDay() - ((world.getTimeOfDay()/seasonLength)*seasonLength) )) % seasonLength)/24000L);
            WDynamicLabel dayLabel = new WDynamicLabel(() -> day);
            dayLabel.paint(matrices, truePos.getA() + 25, truePos.getB() + 34, 1, 1);
            dayLabel.setAlignment(HorizontalAlignment.CENTER);
        }

        //MONEY FUNCTIONALITY
        int money = MyComponents.MONEY.get(mc.player).getMoney();
        WDynamicLabel moneylabel = new WDynamicLabel(() -> String.valueOf(money));
        moneylabel.setAlignment(HorizontalAlignment.RIGHT);
        TextRenderer textRenderer = mc.textRenderer;

        //mc.getItemRenderer().renderGuiItemIcon(universalClock, truePos.getA() + 6, truePos.getB() + 36);

        //textRenderer.draw(matrices, , truePos.getA() + 27, truePos.getB() + 41, 2232610);
        //textRenderer.draw(matrices, money, truePos.getA() + 27, truePos.getB() + 65, 2232610);
        moneylabel.paint(matrices, truePos.getA() + 40, truePos.getB() + 4, 1, 1);
        seasonLabel.paint(matrices, truePos.getA() + 25, truePos.getB() + 24, 1, 1);
        //dayLabel.paint(matrices, truePos.getA() + 28, truePos.getB() + 54, 1, 1);

        matrices.pop();
        RenderSystem.disableBlend();
        mc.getTextureManager().bindTexture(DrawableHelper.GUI_ICONS_TEXTURE);
    }
}
