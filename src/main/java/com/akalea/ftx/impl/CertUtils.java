package com.akalea.ftx.impl;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CertUtils {

    public static SSLContext acceptAllCertificatesSslContext() {
        try {
            TrustManager[] trustAllCerts =
                new TrustManager[] {
                    new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }

                        public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs,
                            String authType) {
                        }

                        public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs,
                            String authType) {
                        }
                    }
                };
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            return sc;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public static void acceptAllCertificates() {
        HttpsURLConnection.setDefaultSSLSocketFactory(
            acceptAllCertificatesSslContext().getSocketFactory());
    }
}
