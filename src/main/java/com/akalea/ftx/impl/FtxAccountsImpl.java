package com.akalea.ftx.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akalea.ftx.FtxApi.Accounts;
import com.akalea.ftx.domain.Account;
import com.akalea.ftx.domain.Auth;
import com.akalea.ftx.domain.SubAccount;
import com.akalea.ftx.domain.SubAccountBalance;

@Service
public class FtxAccountsImpl extends FtxApiBase implements Accounts {

    @Override
    public Account getAccount(Auth auth) {
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
    public List<SubAccount> getSubAccounts(Auth auth) {
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
    public List<SubAccountBalance> getSubAccountBalances(String nickname, Auth auth) {
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

    private static class FtxAccountResponse extends FtxResponse<Account> {

    }

    private static class FtxSubAccountsResponse extends FtxResponse<List<SubAccount>> {

    }

    private static class FtxSubAccountBalancesResponse
        extends
        FtxResponse<List<SubAccountBalance>> {

    }

}
