package com.akalea.ftx.domain;

public class Market {
    public static enum MarketType {
            futures, spot
    }

    private String  name;
    private String  baseCurrency;
    private String  quoteCurrency;
    private boolean enabled;
    private double  ask;
    private double  bid;
    private double  last;
    private boolean postOnly;
    private double  priceIncrement;
    private double  sizeIncrement;
    private boolean restricted;

    public String getName() {
        return name;
    }

    public Market setName(String name) {
        this.name = name;
        return this;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public Market setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
        return this;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public Market setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Market setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public double getAsk() {
        return ask;
    }

    public Market setAsk(double ask) {
        this.ask = ask;
        return this;
    }

    public double getBid() {
        return bid;
    }

    public Market setBid(double bid) {
        this.bid = bid;
        return this;
    }

    public double getLast() {
        return last;
    }

    public Market setLast(double last) {
        this.last = last;
        return this;
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public Market setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
        return this;
    }

    public double getPriceIncrement() {
        return priceIncrement;
    }

    public Market setPriceIncrement(double priceIncrement) {
        this.priceIncrement = priceIncrement;
        return this;
    }

    public double getSizeIncrement() {
        return sizeIncrement;
    }

    public Market setSizeIncrement(double sizeIncrement) {
        this.sizeIncrement = sizeIncrement;
        return this;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public Market setRestricted(boolean restricted) {
        this.restricted = restricted;
        return this;
    }

}
