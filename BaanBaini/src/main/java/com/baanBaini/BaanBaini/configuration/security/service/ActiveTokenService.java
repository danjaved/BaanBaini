package com.baanBaini.BaanBaini.configuration.security.service;

public interface ActiveTokenService {
    void addToken(String userId, String token);
    boolean validateToken(String userId, String token);
    boolean removeToken(String userId, String token);
    boolean removeAllTokens(String userId);
}
