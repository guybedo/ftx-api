package com.akalea.ftx.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akalea.ftx.FtxApi.Futures;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxFutures;

@Service
public class FtxFuturesImpl extends FtxApiBase implements Futures {

    public List<FtxFutures> getFuturesList(FtxCredentials auth) {
        String url = url("api/futures");
        ResponseEntity<FtxFuturesListResponse> resp =
            restTemplate.exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                new ParameterizedTypeReference<FtxFuturesListResponse>() {
                });
        return resp
            .getBody()
            .getResult();
    }

    public FtxFutures getFutures(String futuresName, FtxCredentials auth) {
        String url = url(String.format("api/futures/%s", futuresName));
        ResponseEntity<FtxFuturesResponse> resp =
            restTemplate.exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                new ParameterizedTypeReference<FtxFuturesResponse>() {
                });
        return resp
            .getBody()
            .getResult();
    }

    private static class FtxFuturesListResponse extends FtxResponse<List<FtxFutures>> {

    }

    private static class FtxFuturesResponse extends FtxResponse<FtxFutures> {

    }

}
