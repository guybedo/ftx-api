package com.akalea.ftx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.akalea.ftx.impl.CertUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = "com.akalea.ftx")
public class FtxApiConfiguration {

    @Autowired
    private Environment env;

    public FtxApiConfiguration() {
        CertUtils.acceptAllCertificates();
    }

    public String getProperty(String property) {
        return env.getProperty(property);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper om =
            Jackson2ObjectMapperBuilder
                .json()
                .build();
        om.setSerializationInclusion(Include.NON_NULL);
        return om;
    }

    @Bean
    public RestTemplate restTemplate(ObjectMapper om) {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jacksonConverter =
            new MappingJackson2HttpMessageConverter(om);
        restTemplate.setMessageConverters(
            restTemplate.getMessageConverters()
                .stream()
                .map(c -> c instanceof MappingJackson2HttpMessageConverter ? jacksonConverter : c)
                .collect(Collectors.toList()));

        if (env.acceptsProfiles("debug")) {
            List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
            if (interceptors == null || interceptors.isEmpty()) {
                interceptors = new ArrayList<>();
            }
            interceptors.add(new LoggingInterceptor());
            restTemplate.setInterceptors(interceptors);
        }

        restTemplate.setErrorHandler(new RestErrorHandler());

        return restTemplate;
    }

    public static class RestErrorHandler extends DefaultResponseErrorHandler {

        @Override
        protected boolean hasError(HttpStatus statusCode) {
            return statusCode.is4xxClientError() || statusCode.is5xxServerError();
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            throw new RuntimeException(
                String.format(
                    "Error status code %d: %s",
                    response.getRawStatusCode(),
                    IOUtils.toString(response.getBody())));
        }
    }

    public static class LoggingInterceptor implements ClientHttpRequestInterceptor {

        private static Logger LOGGER = LoggerFactory.getLogger(LoggingInterceptor.class);

        @Override
        public ClientHttpResponse intercept(
            HttpRequest req,
            byte[] reqBody,
            ClientHttpRequestExecution ex)
            throws IOException {
            LOGGER.info("Request body: {}", new String(reqBody, StandardCharsets.UTF_8));
            ClientHttpResponse response = ex.execute(req, reqBody);
            InputStreamReader isr =
                new InputStreamReader(response.getBody(), StandardCharsets.UTF_8);
            String body = new BufferedReader(isr).lines().collect(Collectors.joining("\n"));
            LOGGER.info("Response body: {}", body);
            return response;
        }
    }
}
