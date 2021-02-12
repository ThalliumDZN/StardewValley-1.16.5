package com.thallium.sdvm.gui.hud;

import java.util.function.Supplier;

public enum IntegratedPreset
{
    TOP_RIGHT(OverlayPositionHandler.AnchorPoint.TOP_RIGHT, -67, 2);

    private final OverlayPositionHandler.OverlayPosition position;

    private IntegratedPreset(OverlayPositionHandler.AnchorPoint point, int xOffset, int yOffset)
    {
        this(() -> point, () -> xOffset, () -> yOffset);
    }

    private IntegratedPreset(Supplier<OverlayPositionHandler.AnchorPoint> pointSupplier, Supplier<Integer> xOffsetSupplier, Supplier<Integer> yOffsetSupplier)
    {
        this.position = new OverlayPositionHandler.OverlayPosition(pointSupplier, xOffsetSupplier, yOffsetSupplier);
    }

    public Tuple<Integer, Integer> calculatePosition(int scaledWidth, int scaledHeight)
    {
        return this.position.calculatePosition(scaledWidth, scaledHeight);
    }
}
