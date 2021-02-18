package com.thallium.sdvm.gui.entity.clint;

import com.thallium.sdvm.gui.widgets.WClearButton;
import com.thallium.sdvm.gui.widgets.WQuestionPanel;
import com.thallium.sdvm.registry.ModScreens;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.LiteralText;

public class ClintGuiDescription extends SyncedGuiDescription
{

    public ClintGuiDescription(int syncId, PlayerInventory playerInventory, PlayerEntity player)
    {
        super(ModScreens.CLINT_SHOP, syncId, playerInventory);

        WQuestionPanel root = new WQuestionPanel();
        root.setSize(224, 76);
        setRootPanel(root);

        WClearButton shop = new WClearButton(new LiteralText("Shop"));
        WClearButton upgrade = new WClearButton(new LiteralText("Upgrade Tools"));
        WClearButton leave = new WClearButton(new LiteralText("Leave"));

        root.add(shop, 0, 0);
        root.add(upgrade, 0, 0);
        root.add(leave, 0, 0);

        shop.setSize(220, 10);
        upgrade.setSize(220, 10);
        leave.setSize(220, 10);

        shop.setLocation(10, 10);
        upgrade.setLocation(10, 20);
        leave.setLocation(10, 30);

        shop.setOnClick(()->
        {
            //MyComponents.increment(player, 10);
            //Money money = new Money(player);
            //money.increase(new BigDecimal("1.00"));
            //MyComponents.MONEY.get(player).setValue(12);
        });

        leave.setOnClick(()->{
            MinecraftClient.getInstance().player.closeScreen();
        });

        root.validate(this);
    }

    @Override
    public void addPainters()
    {

    }
}
