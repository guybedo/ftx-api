package com.akalea.ftx.domain;

public class Position {

    private Double       cost;
    private Double       entryPrice;
    private String       future;
    private Double       initialMarginRequirement;
    private Double       longOrderSize;
    private Double       maintenanceMarginRequirement;
    private Double       netSize;
    private Double       openSize;
    private Double       realizedPnl;
    private Double       shortOrderSize;
    private PositionSide side;
    private Double       size;
    private Double       unrealizedPnl;

    public Double getCost() {
        return cost;
    }

    public Position setCost(Double cost) {
        this.cost = cost;
        return this;
    }

    public Double getEntryPrice() {
        return entryPrice;
    }

    public Position setEntryPrice(Double entryPrice) {
        this.entryPrice = entryPrice;
        return this;
    }

    public String getFuture() {
        return future;
    }

    public Position setFuture(String future) {
        this.future = future;
        return this;
    }

    public Double getInitialMarginRequirement() {
        return initialMarginRequirement;
    }

    public Position setInitialMarginRequirement(Double initialMarginRequirement) {
        this.initialMarginRequirement = initialMarginRequirement;
        return this;
    }

    public Double getLongOrderSize() {
        return longOrderSize;
    }

    public Position setLongOrderSize(Double longOrderSize) {
        this.longOrderSize = longOrderSize;
        return this;
    }

    public Double getMaintenanceMarginRequirement() {
        return maintenanceMarginRequirement;
    }

    public Position setMaintenanceMarginRequirement(Double maintenanceMarginRequirement) {
        this.maintenanceMarginRequirement = maintenanceMarginRequirement;
        return this;
    }

    public Double getNetSize() {
        return netSize;
    }

    public Position setNetSize(Double netSize) {
        this.netSize = netSize;
        return this;
    }

    public Double getOpenSize() {
        return openSize;
    }

    public Position setOpenSize(Double openSize) {
        this.openSize = openSize;
        return this;
    }

    public Double getRealizedPnl() {
        return realizedPnl;
    }

    public Position setRealizedPnl(Double realizedPnl) {
        this.realizedPnl = realizedPnl;
        return this;
    }

    public Double getShortOrderSize() {
        return shortOrderSize;
    }

    public Position setShortOrderSize(Double shortOrderSize) {
        this.shortOrderSize = shortOrderSize;
        return this;
    }

    public PositionSide getSide() {
        return side;
    }

    public Position setSide(PositionSide side) {
        this.side = side;
        return this;
    }

    public Double getSize() {
        return size;
    }

    public Position setSize(Double size) {
        this.size = size;
        return this;
    }

    public Double getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public Position setUnrealizedPnl(Double unrealizedPnl) {
        this.unrealizedPnl = unrealizedPnl;
        return this;
    }

}
