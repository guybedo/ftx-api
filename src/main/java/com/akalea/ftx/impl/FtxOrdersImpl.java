package com.akalea.ftx.impl;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akalea.ftx.FtxApi.Orders;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxOrder;

@Service
public class FtxOrdersImpl extends FtxApiBase implements Orders {

    public FtxOrder placeOrder(FtxOrder order, FtxCredentials auth) {
        String url = url("api/orders");

        ResponseEntity<FtxOrderResponse> resp = restTemplate.exchange(
            url,
            HttpMethod.POST,
            signedRequest(url, HttpMethod.POST, order, auth),
            FtxOrderResponse.class);
        return resp
            .getBody()
            .getResult();
    }

    public List<FtxOrder> getOrders(String market, FtxCredentials auth) {
        String url = url(String.format("api/orders?market=%s", market));

        ResponseEntity<FtxOrdersResponse> resp = restTemplate.exchange(
            url,
            HttpMethod.GET,
            signedRequest(url, HttpMethod.GET, null, auth),
            FtxOrdersResponse.class);
        return resp
            .getBody()
            .getResult();
    }

    private static class FtxOrderResponse extends FtxResponse<FtxOrder> {

    }

    private static class FtxOrdersResponse extends FtxResponse<List<FtxOrder>> {

    }
}
