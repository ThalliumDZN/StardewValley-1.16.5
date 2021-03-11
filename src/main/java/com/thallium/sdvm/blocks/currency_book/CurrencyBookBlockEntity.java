package com.thallium.sdvm.blocks.currency_book;

import com.thallium.sdvm.registry.ModEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Nameable;
import net.minecraft.util.Tickable;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CurrencyBookBlockEntity extends BlockEntity implements Nameable, Tickable
{
    public static BlockEntityType<CurrencyBookBlockEntity> TYPE;

    private Text customName;
    public float nextPageTurningSpeed;
    public float pageTurningSpeed;
    public int ticks;
    private static final Random RANDOM = new Random();


    public CurrencyBookBlockEntity()
    {
        super(ModEntity.CURRENCY_BOOK);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag)
    {
        super.toTag(tag);
        if (this.hasCustomName())
        {
            tag.putString("CustomName", Text.Serializer.toJson(this.customName));
        }
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag)
    {
        super.fromTag(state, tag);
        if (tag.contains("CustomName", 8))
        {
            this.customName = Text.Serializer.fromJson(tag.getString("CustomName"));
        }
    }



    @Override
    public Text getName()
    {
        return (Text)(this.customName != null ? this.customName : new TranslatableText("sdvm.container.currency_book"));
    }

    public void setCustomName(@Nullable Text value)
    {
        this.customName = value;
    }

    @Nullable
    @Override
    public Text getCustomName()
    {
        return this.customName;
    }

    @Override
    public void tick()
    {
        this.pageTurningSpeed = this.nextPageTurningSpeed;

    }
}
