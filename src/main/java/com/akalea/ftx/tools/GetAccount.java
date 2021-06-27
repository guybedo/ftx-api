package com.akalea.ftx.tools;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akalea.ftx.FtxApi;
import com.akalea.ftx.configuration.FtxApiConfiguration;
import com.akalea.ftx.domain.FtxAccount;
import com.akalea.ftx.domain.FtxCredentials;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetAccount {

    private final static Logger logger =
        LoggerFactory
            .getLogger(GetAccount.class);

    public static void main(String[] args) throws JsonProcessingException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(FtxApiConfiguration.class);
        context.refresh();
        FtxApi api = context.getBean(FtxApi.class);

        FtxCredentials credentials =
            Optional
                .ofNullable(context.getBean(FtxCredentials.class))
                .orElse(
                    new FtxCredentials()
                        .setApiKey("api-key")
                        .setApiSecret("api-secret"));

        FtxAccount account = api.accounts().getAccount(credentials);
        System.out.println(new ObjectMapper().writeValueAsString(account));

    }
}
