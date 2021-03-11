package com.thallium.sdvm.gui.frienship;

import com.thallium.sdvm.gui.widgets.friendship.WFriendshipPanel;
import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.Identifier;

public class FriendshipGui extends SyncedGuiDescription
{
    private static final Identifier MARLON = new Identifier("sdvm", "textures/gui/friendship/image.png");

    public FriendshipGui(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        super(ModScreens.FRIENDSHIP_SCREEN, syncId, playerInventory);

        WFriendshipPanel root = new WFriendshipPanel();
        root.setSize(214, 147);
        setRootPanel(root);

        /*
        WFriendshipInfo f1 = new WFriendshipInfo(new WSprite(MARLON), new LiteralText("Marlon"));
        root.add(f1, 3, 3, 208, 29);
        WFriendshipInfo f2 = new WFriendshipInfo();
        root.add(f2, 3, 31, 208, 29);
        WFriendshipInfo f3 = new WFriendshipInfo();
        root.add(f3, 3, 59, 208, 29);
        WFriendshipInfo f4 = new WFriendshipInfo();
        root.add(f4, 3, 87, 208, 29);
        WFriendshipInfo f5 = new WFriendshipInfo();
        root.add(f5, 3, 115, 208, 29);
        */
    }

    @Override
    public void addPainters()
    {

    }
}
