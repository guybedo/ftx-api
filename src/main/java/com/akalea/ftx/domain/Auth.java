package com.akalea.ftx.domain;

public class Auth {

    private String apiKey;
    private String apiSecret;
    private String subaccount;

    public String getApiKey() {
        return apiKey;
    }

    public Auth setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public Auth setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }

    public String getSubaccount() {
        return subaccount;
    }

    public Auth setSubaccount(String subaccount) {
        this.subaccount = subaccount;
        return this;
    }

}
