package com.thallium.sdvm.blocks.vendor;

import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class VendingBlock extends BlockWithEntity
{
    public static VendingBlock INSTANCE = new VendingBlock();
    public static BlockItem ITEM = new BlockItem(INSTANCE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    private VendingBlock()
    {
        super(AbstractBlock.Settings.of(Material.STONE).strength(10f, 3600000).nonOpaque());
    }


    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world)
    {
        return new VendingBlockEntity();
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        if(!world.isClient) {
            BlockEntity be = world.getBlockEntity(pos);
            if(be instanceof VendingBlockEntity) {
                if(((VendingBlockEntity) be).tryExchange(player)) {
                    return ActionResult.SUCCESS;
                }

                if(((VendingBlockEntity) be).canPlayerUse(player)) {
                    player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack)
    {
        if(placer instanceof PlayerEntity) {
            BlockEntity be = world.getBlockEntity(pos);
            if(be instanceof VendingBlockEntity) {
                ((VendingBlockEntity) be).owner = ((PlayerEntity) placer).getUuid();
            }
        }
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos)
    {
        BlockEntity be = world.getBlockEntity(pos);
        if(be instanceof VendingBlockEntity && !((VendingBlockEntity) be).canPlayerUse(player)) return 0;

        return super.calcBlockBreakingDelta(state, player, world, pos);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved)
    {
        if(!state.isOf(newState.getBlock())) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof VendingBlockEntity) {
                ItemScatterer.spawn(world, pos, ((VendingBlockEntity) be).invStacks);
            }
        }
    }
}
