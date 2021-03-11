package com.thallium.sdvm.gui.fishing;

import com.thallium.sdvm.gui.widgets.fishing.WFishingBar;
import com.thallium.sdvm.gui.widgets.fishing.WFishingIcon;
import com.thallium.sdvm.gui.widgets.fishing.WFishingPanel;
import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

public class FishingGui extends SyncedGuiDescription
{
    public FishingGui(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        super(ModScreens.FISHING_SCREEN, syncId, playerInventory);

        WFishingPanel bg = new WFishingPanel();
        setRootPanel(bg);
        bg.addPainters();
        bg.setSize(36, 148);

        WFishingBar bar = new WFishingBar(WFishingBar.TEXTURE);
        bg.add(bar, 0, 0, 9, 36);

        WFishingIcon icon = new WFishingIcon(WFishingIcon.TEXTURE);
        bg.add(icon, -139, 0, 13, 14);
    }

    @Override
    public void addPainters()
    {
        //removes the original minecraft gui texture
    }
}
