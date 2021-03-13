package com.thallium.sdvm.gui.fishing;

import com.thallium.sdvm.gui.widgets.fishing.WFishingHook;
import com.thallium.sdvm.gui.widgets.fishing.WFishingIcon;
import com.thallium.sdvm.gui.widgets.fishing.WFishingPanel;
import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.Identifier;

public class FishingGui extends SyncedGuiDescription
{
    public static final Identifier ID = new Identifier("sdvm", "textures/gui/fishing/border.png");
    public static final Texture TEXTURE = new Texture(ID);

    public static WFishingHook bar = new WFishingHook(WFishingHook.TEXTURE);
    public static WFishingIcon icon = new WFishingIcon(WFishingIcon.TEXTURE);
    public static WSprite bBorder = new WSprite(TEXTURE);
    public static WSprite tBorder = new WSprite(TEXTURE);

    public FishingGui(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        super(ModScreens.FISHING_SCREEN, syncId, playerInventory);

        WFishingPanel bg = new WFishingPanel();
        setRootPanel(bg);
        bg.addPainters();
        bg.setSize(36, 148);

        bg.add(bar, 0, 0, 9, 36);
        bg.add(icon, -139, 0, 13, 14);
        bg.add(bBorder, -139, 3, 9, 1);
        bg.add(tBorder, -139, 111, 9, 1);

        bar.requestFocus();
    }

    @Override
    public void addPainters()
    {
        //removes the original minecraft gui texture
    }
}
