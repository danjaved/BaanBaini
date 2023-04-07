package com.baanBaini.BaanBaini.configuration.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private String authority;
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
    Authority(){
    }
    public Authority(String authority){
        this.authority=authority;
    }
    @Override
    public String getAuthority() {
        return this.authority;
    }
}
