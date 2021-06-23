package com.akalea.ftx.domain;

public class SubAccountBalance {
    private String coin;
    private Double free;
    private Double total;
    private Double spotBorrow;
    private Double availableWithoutBorrow;

    public String getCoin() {
        return coin;
    }

    public SubAccountBalance setCoin(String coin) {
        this.coin = coin;
        return this;
    }

    public Double getFree() {
        return free;
    }

    public SubAccountBalance setFree(Double free) {
        this.free = free;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public SubAccountBalance setTotal(Double total) {
        this.total = total;
        return this;
    }

    public Double getSpotBorrow() {
        return spotBorrow;
    }

    public SubAccountBalance setSpotBorrow(Double spotBorrow) {
        this.spotBorrow = spotBorrow;
        return this;
    }

    public Double getAvailableWithoutBorrow() {
        return availableWithoutBorrow;
    }

    public SubAccountBalance setAvailableWithoutBorrow(Double availableWithoutBorrow) {
        this.availableWithoutBorrow = availableWithoutBorrow;
        return this;
    }

}
