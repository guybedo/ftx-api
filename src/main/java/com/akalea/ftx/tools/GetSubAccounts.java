package com.akalea.ftx.tools;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akalea.ftx.FtxApi;
import com.akalea.ftx.FtxApiConfiguration;
import com.akalea.ftx.domain.FtxAccount;
import com.akalea.ftx.domain.FtxCredentials;
import com.akalea.ftx.domain.FtxSubAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetSubAccounts {

    private final static Logger logger =
        LoggerFactory.getLogger(GetSubAccounts.class);

    public static void main(String[] args) throws JsonProcessingException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(FtxApiConfiguration.class);
        context.refresh();
        FtxApi api = context.getBean(FtxApi.class);

        List<FtxSubAccount> accounts =
            api
                .accounts()
                .getSubAccounts(
                    new FtxCredentials()
                        .setApiKey("api-key")
                        .setApiSecret("api-secret"));
        System.out.println(new ObjectMapper().writeValueAsString(accounts));

    }
}
