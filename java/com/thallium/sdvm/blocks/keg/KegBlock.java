package com.thallium.sdvm.blocks.keg;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

public class KegBlock extends Block
{
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");

    public KegBlock(Settings settings)
    {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(POWERED);
    }
}
