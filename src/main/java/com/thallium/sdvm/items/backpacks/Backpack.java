package com.thallium.sdvm.items.backpacks;

import com.thallium.sdvm.registry.ModScreens;
import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.TrinketItem;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Backpack extends Item implements NamedScreenHandlerFactory
{
    public Backpack()
    {
        super(new Item.Settings().group(ItemGroup.TOOLS).maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        user.openHandledScreen(this);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public Text getDisplayName()
    {
        return new TranslatableText("Backpack");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player)
    {
        return new BackpackGuiDescription(syncId, inv, ScreenHandlerContext.EMPTY);
    }
}
