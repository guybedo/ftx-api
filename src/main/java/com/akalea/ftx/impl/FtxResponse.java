package com.akalea.ftx.impl;

public class FtxResponse<T> {

    private boolean success;
    private T       result;

    public boolean isSuccess() {
        return success;
    }

    public FtxResponse<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getResult() {
        return result;
    }

    public FtxResponse<T> setResult(T result) {
        this.result = result;
        return this;
    }

}
