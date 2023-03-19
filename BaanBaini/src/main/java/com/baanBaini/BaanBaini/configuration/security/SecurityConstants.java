package com.baanBaini.BaanBaini.configuration.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864000000;
    public static final String HEADER_STRING = "Authorization";;
    public static final String TOKEN_PREFIX ="Bearer_" ;

    public static Key getTokenSecret() {
        String secretKey="BB_UL1BDB17TX85R9AXCVOVSXXQMXGFS3B2WWPSERIAPWJP9FP3462YWFJWXT6OOY";
        Key key=Keys.hmacShaKeyFor(secretKey.getBytes());
        return key;
    }
}
