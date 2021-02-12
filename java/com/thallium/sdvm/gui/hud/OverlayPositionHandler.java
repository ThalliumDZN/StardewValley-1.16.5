package com.thallium.sdvm.gui.hud;

import java.util.function.Supplier;

public class OverlayPositionHandler
{
    public static enum AnchorPoint
    {
        TOP_RIGHT(1, -1);

        private final int xState;
        private final int yState;

        private AnchorPoint(int xState, int yState)
        {
            this.xState = xState;
            this.yState = yState;
        }

        public Tuple<Integer, Integer> calculateBasePos(int scaledWidth, int scaledHeight)
        {
            int basePosX = this.xState == -1 ? 0 : (this.xState == 0 ? scaledWidth/4 : (this.xState == 1 ? scaledWidth : 0));
            int basePosY = this.yState == -1 ? 0 : (this.yState == 0 ? scaledHeight/4 : (this.yState == 1 ? scaledHeight : 0));

            return new Tuple<>(basePosX, basePosY);
        }
    }

    public static class OverlayPosition
    {
        public final Supplier<AnchorPoint> point;
        public final Supplier<Integer> offsetX;
        public final Supplier<Integer> offsetY;

        public OverlayPosition(Supplier<AnchorPoint> point, Supplier<Integer> offsetX, Supplier<Integer> offsetY)
        {
            this.point = point;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
        }

        public Tuple<Integer, Integer> calculatePosition(int scaledWidth, int scaledHeight)
        {
            Tuple<Integer, Integer> basePos = this.point.get().calculateBasePos(scaledWidth, scaledHeight);
            int posX = basePos.getA() + this.offsetX.get();
            int posY = basePos.getB() + this.offsetY.get();

            //return new Pair<>(posX, posY);
            return new Tuple<>(posX, posY);
        }
    }
}
