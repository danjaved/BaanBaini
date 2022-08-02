package com.baanBaini.BaanBaini.configuration.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface LoginService extends UserDetailsService {
    UserDetails getUserByPublicId(String publicId);
}
