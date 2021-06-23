package com.akalea.ftx.domain;

import java.time.LocalDateTime;

public class FtxOrder {

    public static enum OrderType {
            limit, market, stop, trailingStop, takeProfit
    }

    private Integer       id;
    private LocalDateTime createdAt;
    private Integer       filledSize;
    private String        future;
    private String        market;
    private Double        price;
    private Double        avgFillPrice;
    private Integer       remainingSize;
    private FtxPositionSide  side;
    private Integer       size;
    private String        status;
    private OrderType     type;

    private boolean reduceOnly;
    private boolean ioc;
    private boolean postOnly;
    private boolean retryUntilFilled;

    private Integer clientId;

    public Integer getId() {
        return id;
    }

    public FtxOrder setId(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public FtxOrder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Integer getFilledSize() {
        return filledSize;
    }

    public FtxOrder setFilledSize(Integer filledSize) {
        this.filledSize = filledSize;
        return this;
    }

    public String getFuture() {
        return future;
    }

    public FtxOrder setFuture(String future) {
        this.future = future;
        return this;
    }

    public String getMarket() {
        return market;
    }

    public FtxOrder setMarket(String market) {
        this.market = market;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public FtxOrder setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Double getAvgFillPrice() {
        return avgFillPrice;
    }

    public FtxOrder setAvgFillPrice(Double avgFillPrice) {
        this.avgFillPrice = avgFillPrice;
        return this;
    }

    public Integer getRemainingSize() {
        return remainingSize;
    }

    public FtxOrder setRemainingSize(Integer remainingSize) {
        this.remainingSize = remainingSize;
        return this;
    }

    public FtxPositionSide getSide() {
        return side;
    }

    public FtxOrder setSide(FtxPositionSide side) {
        this.side = side;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public FtxOrder setSize(Integer size) {
        this.size = size;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public FtxOrder setStatus(String status) {
        this.status = status;
        return this;
    }

    public OrderType getType() {
        return type;
    }

    public FtxOrder setType(OrderType type) {
        this.type = type;
        return this;
    }

    public boolean isReduceOnly() {
        return reduceOnly;
    }

    public FtxOrder setReduceOnly(boolean reduceOnly) {
        this.reduceOnly = reduceOnly;
        return this;
    }

    public boolean isIoc() {
        return ioc;
    }

    public FtxOrder setIoc(boolean ioc) {
        this.ioc = ioc;
        return this;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public FtxOrder setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
        return this;
    }

    public Integer getClientId() {
        return clientId;
    }

    public FtxOrder setClientId(Integer clientId) {
        this.clientId = clientId;
        return this;
    }

    public boolean isRetryUntilFilled() {
        return retryUntilFilled;
    }

    public FtxOrder setRetryUntilFilled(boolean retryUntilFilled) {
        this.retryUntilFilled = retryUntilFilled;
        return this;
    }

}
