package com.akalea.ftx.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akalea.ftx.FtxApi.Markets;
import com.akalea.ftx.domain.Auth;
import com.akalea.ftx.domain.Market;

@Service
public class FtxMarketsImpl extends FtxApiBase implements Markets {

    public List<Market> getMarkets(Auth auth) {
        String url = url("api/markets");
        ResponseEntity<FtxMarketResponse> resp =
            restTemplate.exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                new ParameterizedTypeReference<FtxMarketResponse>() {
                });
        return resp
            .getBody()
            .getResult();
    }

    private static class FtxMarketResponse extends FtxResponse<List<Market>> {

    }

}
