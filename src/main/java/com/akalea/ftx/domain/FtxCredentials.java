package com.akalea.ftx.domain;

public class FtxCredentials {

    private String apiKey;
    private String apiSecret;
    private String subaccount;

    public String getApiKey() {
        return apiKey;
    }

    public FtxCredentials setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public FtxCredentials setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }

    public String getSubaccount() {
        return subaccount;
    }

    public FtxCredentials setSubaccount(String subaccount) {
        this.subaccount = subaccount;
        return this;
    }

}
