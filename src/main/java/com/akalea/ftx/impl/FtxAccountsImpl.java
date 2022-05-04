package com.akalea.ftx.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akalea.ftx.FtxApi.Accounts;
import com.akalea.ftx.domain.FtxAccount;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxPosition;
import com.akalea.ftx.domain.FtxSubAccount;
import com.akalea.ftx.domain.FtxSubAccountBalance;

@Service
public class FtxAccountsImpl extends FtxApiBase implements Accounts {

    @Override
    public FtxAccount getAccount(FtxCredentials auth) {
        String url = url("api/account");
        ResponseEntity<FtxAccountResponse> resp = restTemplate
            .exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                FtxAccountResponse.class);
        return resp.getBody().getResult();
    }

    @Override
    public List<FtxSubAccount> getSubAccounts(FtxCredentials auth) {
        String url = url("api/subaccounts");
        ResponseEntity<FtxSubAccountsResponse> resp = restTemplate
            .exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                new ParameterizedTypeReference<FtxSubAccountsResponse>() {
                });
        return resp.getBody().getResult();
    }

    @Override
    public List<FtxSubAccountBalance> getSubAccountBalances(String nickname,
            FtxCredentials auth) {
        String url = url(
            String.format("api/subaccounts/%s/balances", nickname));
        ResponseEntity<FtxSubAccountBalancesResponse> resp = restTemplate
            .exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                new ParameterizedTypeReference<FtxSubAccountBalancesResponse>() {
                });
        return resp.getBody().getResult();
    }

    @Override
    public Double getSubAccountFreeCollateral(String nickname, String coin,
            FtxCredentials auth) {
        return getSubAccountBalances(nickname, auth)
            .stream()
            .filter(b -> coin == null || b.getCoin().equals(coin))
            .map(b -> b.getFree())
            .reduce((a, b) -> a + b)
            .orElse(0d);
    }

    @Override
    public Double getMainAccountFreeCollateral(String coin,
            FtxCredentials auth) {
        return getAccount(auth).getFreeCollateral();
    }

    @Override
    public Double getFreeCollateral(String coin, FtxCredentials auth) {
        return Optional
            .ofNullable(auth.getSubaccount())
            .map(sa -> getSubAccountFreeCollateral(sa, coin, auth))
            .orElseGet(() -> getMainAccountFreeCollateral(coin, auth));
    }

    public List<FtxPosition> getPositions(String market, FtxCredentials auth) {
        return getPositions(auth)
            .stream()
            .filter(p -> p.getFuture().equals(market))
            .collect(Collectors.toList());
    }

    public List<FtxPosition> getPositions(FtxCredentials auth) {
        String url = url("api/positions");

        ResponseEntity<FtxPositionsResponse> resp = restTemplate.exchange(
            url,
            HttpMethod.GET,
            signedRequest(url, HttpMethod.GET, null, auth),
            FtxPositionsResponse.class);
        return resp
            .getBody()
            .getResult();
    }

    private static class FtxPositionsResponse
            extends FtxResponse<List<FtxPosition>> {

    }

    private static class FtxAccountResponse extends FtxResponse<FtxAccount> {

    }

    private static class FtxSubAccountsResponse
            extends FtxResponse<List<FtxSubAccount>> {

    }

    private static class FtxSubAccountBalancesResponse
            extends FtxResponse<List<FtxSubAccountBalance>> {

    }

}
