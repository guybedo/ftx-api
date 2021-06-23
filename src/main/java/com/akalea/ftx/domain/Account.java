package com.akalea.ftx.domain;

import java.util.List;

import com.google.common.collect.Lists;

public class Account {

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

    private List<Position> positions = Lists.newArrayList();

    public boolean isBackstopProvider() {
        return backstopProvider;
    }

    public Account setBackstopProvider(boolean backstopProvider) {
        this.backstopProvider = backstopProvider;
        return this;
    }

    public Double getCollateral() {
        return collateral;
    }

    public Account setCollateral(Double collateral) {
        this.collateral = collateral;
        return this;
    }

    public Double getFreeCollateral() {
        return freeCollateral;
    }

    public Account setFreeCollateral(Double freeCollateral) {
        this.freeCollateral = freeCollateral;
        return this;
    }

    public Double getInitialMarginRequirement() {
        return initialMarginRequirement;
    }

    public Account setInitialMarginRequirement(Double initialMarginRequirement) {
        this.initialMarginRequirement = initialMarginRequirement;
        return this;
    }

    public Integer getLeverage() {
        return leverage;
    }

    public Account setLeverage(Integer leverage) {
        this.leverage = leverage;
        return this;
    }

    public boolean isLiquidating() {
        return liquidating;
    }

    public Account setLiquidating(boolean liquidating) {
        this.liquidating = liquidating;
        return this;
    }

    public Double getMaintenanceMarginRequirement() {
        return maintenanceMarginRequirement;
    }

    public Account setMaintenanceMarginRequirement(Double maintenanceMarginRequirement) {
        this.maintenanceMarginRequirement = maintenanceMarginRequirement;
        return this;
    }

    public Double getMakerFee() {
        return makerFee;
    }

    public Account setMakerFee(Double makerFee) {
        this.makerFee = makerFee;
        return this;
    }

    public Double getMarginFraction() {
        return marginFraction;
    }

    public Account setMarginFraction(Double marginFraction) {
        this.marginFraction = marginFraction;
        return this;
    }

    public Double getOpenMarginFraction() {
        return openMarginFraction;
    }

    public Account setOpenMarginFraction(Double openMarginFraction) {
        this.openMarginFraction = openMarginFraction;
        return this;
    }

    public Double getTakerFee() {
        return takerFee;
    }

    public Account setTakerFee(Double takerFee) {
        this.takerFee = takerFee;
        return this;
    }

    public Double getTotalAccountValue() {
        return totalAccountValue;
    }

    public Account setTotalAccountValue(Double totalAccountValue) {
        this.totalAccountValue = totalAccountValue;
        return this;
    }

    public Double getTotalPositionSize() {
        return totalPositionSize;
    }

    public Account setTotalPositionSize(Double totalPositionSize) {
        this.totalPositionSize = totalPositionSize;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public Account setPositions(List<Position> positions) {
        this.positions = positions;
        return this;
    }

}
