package com.thallium.sdvm.gui.popup;

import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.Identifier;

public class VillagerPopupDescription extends SyncedGuiDescription
{
    private static final Identifier question_panel = new Identifier("sdvm", "textures/gui/question_panel.png");

    public VillagerPopupDescription(int syncId, PlayerInventory inventory, ScreenHandlerContext empty, PlayerEntity player)
    {
        super(ModScreens.VILLAGER_POPUP, syncId, inventory, getBlockInventory(empty), getBlockPropertyDelegate(empty));
    }
}
