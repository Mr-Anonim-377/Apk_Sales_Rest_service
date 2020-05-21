package com.Sales.SalesWeb.service.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class CryptoUtils {


    public String getHash(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] saltByte = salt.getBytes(StandardCharsets.UTF_8);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), saltByte, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return String.format("%X", new BigInteger(hash));
    }

}
