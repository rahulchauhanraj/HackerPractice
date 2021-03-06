package com.rahul.hacker.problems;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.security.KeyStore;

public class ConnectAppVault {

    private static String keyPassphrase = "test123";

    static String keyStoreFile = "/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre/lib/security/test-cert.jks";

    public static void main (String args[]) throws Exception{

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(keyStoreFile), keyPassphrase.toCharArray());
            System.out.println(keyStore);

            SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, keyPassphrase.toCharArray()).build();

            CloseableHttpClient httpClient = HttpClients.custom().setSslcontext(sslContext).build();
            CloseableHttpResponse response = httpClient.execute(new HttpPost("https://localhost:8080/KeypairAuth/register"));
            System.out.println(response);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
