package com.akalea.ftx.impl;

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

        ResponseEntity<FtxOrderResponse> resp =
            restTemplate.exchange(
                url,
                HttpMethod.POST,
                signedRequest(url, HttpMethod.POST, order, auth),
                FtxOrderResponse.class);
        return resp
            .getBody()
            .getResult();
    }

    private static class FtxOrderResponse extends FtxResponse<FtxOrder> {

    }
}
