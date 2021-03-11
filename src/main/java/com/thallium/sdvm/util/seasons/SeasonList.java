package com.thallium.sdvm.util.seasons;

import net.minecraft.util.StringIdentifiable;

public enum SeasonList implements StringIdentifiable
{
    SPRING,
    SUMMER,
    FALL,
    WINTER;

    @Override
    public String asString() {
        return name().toLowerCase();
    }

    public SeasonList getNext() {
        switch (this) {
            case SUMMER:
                return SeasonList.FALL;
            case FALL:
                return SeasonList.WINTER;
            case WINTER:
                return SeasonList.SPRING;
            default:
                return SeasonList.SUMMER;
        }
    }
}
