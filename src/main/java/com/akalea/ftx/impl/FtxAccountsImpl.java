package com.akalea.ftx.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akalea.ftx.FtxApi.Accounts;
import com.akalea.ftx.domain.FtxAccount;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxSubAccount;
import com.akalea.ftx.domain.FtxSubAccountBalance;

@Service
public class FtxAccountsImpl extends FtxApiBase implements Accounts {

    @Override
    public FtxAccount getAccount(FtxCredentials auth) {
        String url = url("api/account");
        ResponseEntity<FtxAccountResponse> resp =
            restTemplate.exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                FtxAccountResponse.class);
        return resp
            .getBody()
            .getResult();
    }

    @Override
    public List<FtxSubAccount> getSubAccounts(FtxCredentials auth) {
        String url = url("api/subaccounts");
        ResponseEntity<FtxSubAccountsResponse> resp =
            restTemplate.exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                new ParameterizedTypeReference<FtxSubAccountsResponse>() {
                });
        return resp
            .getBody()
            .getResult();
    }

    @Override
    public List<FtxSubAccountBalance> getSubAccountBalances(String nickname, FtxCredentials auth) {
        String url = url(String.format("api/subaccounts/%s/balances", nickname));
        ResponseEntity<FtxSubAccountBalancesResponse> resp =
            restTemplate.exchange(
                url,
                HttpMethod.GET,
                signedRequest(url, HttpMethod.GET, null, auth),
                new ParameterizedTypeReference<FtxSubAccountBalancesResponse>() {
                });
        return resp
            .getBody()
            .getResult();
    }

    private static class FtxAccountResponse extends FtxResponse<FtxAccount> {

    }

    private static class FtxSubAccountsResponse extends FtxResponse<List<FtxSubAccount>> {

    }

    private static class FtxSubAccountBalancesResponse
        extends
        FtxResponse<List<FtxSubAccountBalance>> {

    }

}
