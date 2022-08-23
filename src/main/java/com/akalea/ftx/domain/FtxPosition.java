package com.akalea.ftx.domain;

public class FtxPosition {

    private Double       cost;
    private Double       entryPrice;
    private String       future;
    private Double       initialMarginRequirement;
    private Double       longOrderSize;
    private Double       maintenanceMarginRequirement;
    private Double       netSize;
    private Double       openSize;
    private Double		 recentPnl;
    private Double       realizedPnl;
    private Double       shortOrderSize;
    private FtxPositionSide side;
    private Double       size;
    private Double       unrealizedPnl;

    public Double getCost() {
        return cost;
    }

    public FtxPosition setCost(Double cost) {
        this.cost = cost;
        return this;
    }

    public Double getEntryPrice() {
        return entryPrice;
    }

    public FtxPosition setEntryPrice(Double entryPrice) {
        this.entryPrice = entryPrice;
        return this;
    }

    public String getFuture() {
        return future;
    }

    public FtxPosition setFuture(String future) {
        this.future = future;
        return this;
    }

    public Double getInitialMarginRequirement() {
        return initialMarginRequirement;
    }

    public FtxPosition setInitialMarginRequirement(Double initialMarginRequirement) {
        this.initialMarginRequirement = initialMarginRequirement;
        return this;
    }

    public Double getLongOrderSize() {
        return longOrderSize;
    }

    public FtxPosition setLongOrderSize(Double longOrderSize) {
        this.longOrderSize = longOrderSize;
        return this;
    }

    public Double getMaintenanceMarginRequirement() {
        return maintenanceMarginRequirement;
    }

    public FtxPosition setMaintenanceMarginRequirement(Double maintenanceMarginRequirement) {
        this.maintenanceMarginRequirement = maintenanceMarginRequirement;
        return this;
    }

    public Double getNetSize() {
        return netSize;
    }

    public FtxPosition setNetSize(Double netSize) {
        this.netSize = netSize;
        return this;
    }

    public Double getOpenSize() {
        return openSize;
    }

    public FtxPosition setOpenSize(Double openSize) {
        this.openSize = openSize;
        return this;
    }

    public Double getRealizedPnl() {
        return realizedPnl;
    }

    public FtxPosition setRealizedPnl(Double realizedPnl) {
        this.realizedPnl = realizedPnl;
        return this;
    }

    public Double getShortOrderSize() {
        return shortOrderSize;
    }

    public FtxPosition setShortOrderSize(Double shortOrderSize) {
        this.shortOrderSize = shortOrderSize;
        return this;
    }

    public FtxPositionSide getSide() {
        return side;
    }

    public FtxPosition setSide(FtxPositionSide side) {
        this.side = side;
        return this;
    }

    public Double getSize() {
        return size;
    }

    public FtxPosition setSize(Double size) {
        this.size = size;
        return this;
    }

    public Double getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public FtxPosition setUnrealizedPnl(Double unrealizedPnl) {
        this.unrealizedPnl = unrealizedPnl;
        return this;
    }

	public Double getRecentPnl() {
		return recentPnl;
	}

	public void setRecentPnl(Double recentPnl) {
		this.recentPnl = recentPnl;
	}

}
