package com.akalea.ftx.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akalea.ftx.FtxApi;
import com.akalea.ftx.FtxApi.AuthenticatedFtxApi;
import com.akalea.ftx.configuration.FtxApiConfiguration;
import com.akalea.ftx.domain.FtxAccount;
import com.akalea.ftx.domain.FtxCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAccount {

    public static void main(String[] args) throws FileNotFoundException, IOException {
    	Properties credentialsProp = new Properties();
    	credentialsProp.load(new FileInputStream("./src/test/resources/user-credentials.properties"));
    	
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(FtxApiConfiguration.class);
        context.refresh();
        FtxApi api = context.getBean(FtxApi.class);

        FtxCredentials credentials =
                new FtxCredentials()
                .setApiKey(credentialsProp.getProperty("apiKey"))
                .setApiSecret(credentialsProp.getProperty("apiSecret"));

        AuthenticatedFtxApi apiAuth = api.withAuth(credentials);
        
        FtxAccount account = apiAuth.accounts().getAccount();
        System.out.println(new ObjectMapper().writeValueAsString(account));

        context.close();
    }
}
