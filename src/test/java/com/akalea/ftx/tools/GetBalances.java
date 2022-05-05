package com.akalea.ftx.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akalea.ftx.FtxApi;
import com.akalea.ftx.configuration.FtxApiConfiguration;
import com.akalea.ftx.domain.FtxBalance;
import com.akalea.ftx.domain.FtxCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetBalances {

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

        //FtxAccount account = api.accounts().getAccount(credentials);
        //System.out.println(new ObjectMapper().writeValueAsString(account));
        
        List<FtxBalance> b = api.withAuth(credentials).wallet().getBalances();

        System.out.println(new ObjectMapper().writeValueAsString( b ));
        
        context.close();
    }
}
