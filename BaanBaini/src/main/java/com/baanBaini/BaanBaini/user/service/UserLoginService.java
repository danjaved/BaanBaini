package com.baanBaini.BaanBaini.user.service;

import com.baanBaini.BaanBaini.user.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserLoginService extends UserDetailsService {
    UserDto addUser(UserDto user);
    UserDto getUserByEmailId(String emailId);

    UserDto getUserByPublicId(String userId);
}
