package com.akalea.ftx.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akalea.ftx.FtxApi.Markets;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxMarket;

@Service
public class FtxMarketsImpl extends FtxApiBase implements Markets {

    public List<FtxMarket> getMarkets(FtxCredentials auth) {
        String url = url("api/markets");
        ResponseEntity<FtxMarketsResponse> resp =
            restTemplate.exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                new ParameterizedTypeReference<FtxMarketsResponse>() {
                });
        return resp
            .getBody()
            .getResult();
    }

    public FtxMarket getMarket(String market, FtxCredentials auth) {
        String url = url(String.format("api/markets/%s", market));
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

    private static class FtxMarketsResponse extends FtxResponse<List<FtxMarket>> {

    }

    private static class FtxMarketResponse extends FtxResponse<FtxMarket> {

    }

}
