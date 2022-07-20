package com.baanBaini.BaanBaini.user.service;

import com.baanBaini.BaanBaini.user.model.dto.UserDto;

public interface UserLoginService  {
    UserDto addUser(UserDto user);
    UserDto getUserByEmailId(String emailId);

    UserDto getUserByPublicId(String userId);
}
