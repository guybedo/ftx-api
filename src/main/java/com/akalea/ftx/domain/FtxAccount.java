package com.akalea.ftx.domain;

import java.util.List;

import com.google.common.collect.Lists;

public class FtxAccount {

    private boolean backstopProvider;
    private Double  collateral;
    private Double  freeCollateral;
    private Double  initialMarginRequirement;
    private Integer leverage;
    private boolean liquidating;
    private Double  maintenanceMarginRequirement;
    private Double  makerFee;
    private Double  marginFraction;
    private Double  openMarginFraction;
    private Double  takerFee;
    private Double  totalAccountValue;
    private Double  totalPositionSize;
    private String  username;

    private List<FtxPosition> positions = Lists.newArrayList();

    public boolean isBackstopProvider() {
        return backstopProvider;
    }

    public FtxAccount setBackstopProvider(boolean backstopProvider) {
        this.backstopProvider = backstopProvider;
        return this;
    }

    public Double getCollateral() {
        return collateral;
    }

    public FtxAccount setCollateral(Double collateral) {
        this.collateral = collateral;
        return this;
    }

    public Double getFreeCollateral() {
        return freeCollateral;
    }

    public FtxAccount setFreeCollateral(Double freeCollateral) {
        this.freeCollateral = freeCollateral;
        return this;
    }

    public Double getInitialMarginRequirement() {
        return initialMarginRequirement;
    }

    public FtxAccount setInitialMarginRequirement(Double initialMarginRequirement) {
        this.initialMarginRequirement = initialMarginRequirement;
        return this;
    }

    public Integer getLeverage() {
        return leverage;
    }

    public FtxAccount setLeverage(Integer leverage) {
        this.leverage = leverage;
        return this;
    }

    public boolean isLiquidating() {
        return liquidating;
    }

    public FtxAccount setLiquidating(boolean liquidating) {
        this.liquidating = liquidating;
        return this;
    }

    public Double getMaintenanceMarginRequirement() {
        return maintenanceMarginRequirement;
    }

    public FtxAccount setMaintenanceMarginRequirement(Double maintenanceMarginRequirement) {
        this.maintenanceMarginRequirement = maintenanceMarginRequirement;
        return this;
    }

    public Double getMakerFee() {
        return makerFee;
    }

    public FtxAccount setMakerFee(Double makerFee) {
        this.makerFee = makerFee;
        return this;
    }

    public Double getMarginFraction() {
        return marginFraction;
    }

    public FtxAccount setMarginFraction(Double marginFraction) {
        this.marginFraction = marginFraction;
        return this;
    }

    public Double getOpenMarginFraction() {
        return openMarginFraction;
    }

    public FtxAccount setOpenMarginFraction(Double openMarginFraction) {
        this.openMarginFraction = openMarginFraction;
        return this;
    }

    public Double getTakerFee() {
        return takerFee;
    }

    public FtxAccount setTakerFee(Double takerFee) {
        this.takerFee = takerFee;
        return this;
    }

    public Double getTotalAccountValue() {
        return totalAccountValue;
    }

    public FtxAccount setTotalAccountValue(Double totalAccountValue) {
        this.totalAccountValue = totalAccountValue;
        return this;
    }

    public Double getTotalPositionSize() {
        return totalPositionSize;
    }

    public FtxAccount setTotalPositionSize(Double totalPositionSize) {
        this.totalPositionSize = totalPositionSize;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public FtxAccount setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<FtxPosition> getPositions() {
        return positions;
    }

    public FtxAccount setPositions(List<FtxPosition> positions) {
        this.positions = positions;
        return this;
    }

}
