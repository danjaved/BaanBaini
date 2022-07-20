package com.baanBaini.BaanBaini.configuration.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    private String authority;
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
