package com.akalea.ftx.impl;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akalea.ftx.FtxApi.Wallet;
import com.akalea.ftx.domain.FtxBalance;
import com.akalea.ftx.domain.FtxCredentials;

@Service
public class FtxWalletImpl  extends FtxApiBase implements Wallet{

	@Override
	public List<FtxBalance> getBalances(FtxCredentials auth) {
		String url = url(String.format("api/wallet/balances"));
		
        ResponseEntity<FtxBalancesResponse> resp = restTemplate.exchange(
            url,
            HttpMethod.GET,
            signedRequest(url, HttpMethod.GET, null, auth),
            FtxBalancesResponse.class);
        return resp
            .getBody()
            .getResult();
	}
	
	
	 private static class FtxBalancesResponse extends FtxResponse<List<FtxBalance>> {

	 }

}
