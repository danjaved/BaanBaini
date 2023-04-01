package com.baanBaini.BaanBaini.configuration.security.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class ActiveTokensEntity {
    @Id
    private String userId;
    private List<String> tokens;

    public ActiveTokensEntity() {
    }

    public ActiveTokensEntity(String userId, String token) {
        this.userId=userId;
        this.tokens =new ArrayList<>();
        this.tokens.add(token);
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getTokens() {
        return tokens;
    }
}
