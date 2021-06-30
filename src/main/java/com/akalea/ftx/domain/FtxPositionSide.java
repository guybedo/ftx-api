package com.akalea.ftx.domain;

public enum FtxPositionSide {
    buy, sell;

    public static FtxPositionSide getOppositeSide(FtxPositionSide side) {
        return FtxPositionSide.buy.equals(side) ? FtxPositionSide.sell
                : FtxPositionSide.buy;
    }
}