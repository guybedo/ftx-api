package com.akalea.ftx.domain;

public class FtxSubAccountBalance {
    private String coin;
    private Double free;
    private Double total;
    private Double spotBorrow;
    private Double availableWithoutBorrow;

    public String getCoin() {
        return coin;
    }

    public FtxSubAccountBalance setCoin(String coin) {
        this.coin = coin;
        return this;
    }

    public Double getFree() {
        return free;
    }

    public FtxSubAccountBalance setFree(Double free) {
        this.free = free;
        return this;
    }

    public Double getTotal() {
        return total;
    }

    public FtxSubAccountBalance setTotal(Double total) {
        this.total = total;
        return this;
    }

    public Double getSpotBorrow() {
        return spotBorrow;
    }

    public FtxSubAccountBalance setSpotBorrow(Double spotBorrow) {
        this.spotBorrow = spotBorrow;
        return this;
    }

    public Double getAvailableWithoutBorrow() {
        return availableWithoutBorrow;
    }

    public FtxSubAccountBalance setAvailableWithoutBorrow(Double availableWithoutBorrow) {
        this.availableWithoutBorrow = availableWithoutBorrow;
        return this;
    }

}
