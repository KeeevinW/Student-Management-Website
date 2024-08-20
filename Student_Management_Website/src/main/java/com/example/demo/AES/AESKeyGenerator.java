package com.example.demo.AES;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESKeyGenerator {

    public static void main(String[] args) throws Exception {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey key = keyGenerator.generateKey();

        String keyBase64 = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Key:" + keyBase64);
    }
}
