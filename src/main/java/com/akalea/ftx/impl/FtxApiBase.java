package com.akalea.ftx.impl;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.akalea.ftx.domain.FtxCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;

public class FtxApiBase {

    private static String baseUrl          = "https://ftx.com";
    private static String ftxServerTimeUrl = "https://otc.ftx.com/api/time";
    private static String userAgent        =
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36";

    @Autowired
    protected ObjectMapper om;
    @Autowired
    protected RestTemplate restTemplate;

    protected String url(String path) {
        return String.format("%s/%s", baseUrl, path);
    }

    @SuppressWarnings("unchecked")
    protected <T> HttpEntity signedRequest(String url, HttpMethod method, Object body, FtxCredentials auth) {

        String path = url.substring(baseUrl.length());
        long timestamp = System.currentTimeMillis();
        StringBuilder signaturePayload =
            new StringBuilder()
                .append(String.valueOf(timestamp))
                .append(method.name())
                .append(path);

        String bodyPayload =
            Optional
                .ofNullable(body)
                .map(b -> {
                    try {
                        return om.writeValueAsString(b);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .orElse(null);
        if (bodyPayload != null) {
            signaturePayload.append(bodyPayload);
        }
        String signature = guavaHmacSha256Base64(signaturePayload.toString(), auth.getApiSecret());

        MultiValueMap headers = new LinkedMultiValueMap();
        headers.put("Accept", Lists.newArrayList("application/json"));
        headers.put("Content-Type", Lists.newArrayList("application/json"));
        headers.put("user-agent", Lists.newArrayList(userAgent));
        headers.put("FTX-KEY", Lists.newArrayList(auth.getApiKey()));
        headers.put("FTX-SIGN", Lists.newArrayList(signature));
        headers.put("FTX-TS", Lists.newArrayList(String.valueOf(timestamp)));
        if (auth.getSubaccount() != null)
            headers.put("FTX-SUBACCOUNT", Lists.newArrayList(auth.getSubaccount()));

        return new HttpEntity(bodyPayload, headers);
    }

    public long getFtxServerTimestamp() {
        MultiValueMap headers = new LinkedMultiValueMap();
        headers.put("Accept", Lists.newArrayList("application/json"));
        headers.put("user-agent", Lists.newArrayList(userAgent));
        String dateStr =
            restTemplate
                .exchange(
                    ftxServerTimeUrl,
                    HttpMethod.GET,
                    new HttpEntity(null, headers),
                    FtxTimeResponse.class)
                .getBody()
                .getResult();
        LocalDateTime date =
            LocalDateTime
                .parse(
                    dateStr,
                    DateTimeFormatter.ISO_DATE_TIME);
        return date.toEpochSecond(ZoneOffset.ofHoursMinutes(0, 0)) * 1000;
    }

    public static String guavaHmacSha256Base64(String message, String key) {
        return Hashing
            .hmacSha256(key.getBytes(StandardCharsets.ISO_8859_1))
            .hashString(message, StandardCharsets.ISO_8859_1)
            .toString();
    }

    public static String hmacSha256Base64(String message, String secretKey) {
        try {
            Mac hmacSha256;
            try {
                hmacSha256 = Mac.getInstance("HmacSHA256");
            } catch (NoSuchAlgorithmException nsae) {
                hmacSha256 = Mac.getInstance("HMAC-SHA-256");
            }
            SecretKeySpec secretKeySpec =
                new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            hmacSha256.init(secretKeySpec);
            return Hex.encodeHexString(hmacSha256.doFinal(message.getBytes("UTF-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class FtxTimeResponse extends FtxResponse<String> {

    }
}
