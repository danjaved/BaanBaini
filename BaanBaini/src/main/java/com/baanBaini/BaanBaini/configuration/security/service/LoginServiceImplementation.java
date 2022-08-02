package com.baanBaini.BaanBaini.configuration.security.service;

import com.baanBaini.BaanBaini.SpringApplicationContext;
import com.baanBaini.BaanBaini.admin.model.dto.AdminDTO;
import com.baanBaini.BaanBaini.admin.service.AdminLoginService;
import com.baanBaini.BaanBaini.shared.utility.MapperUtility;
import com.baanBaini.BaanBaini.user.model.dto.UserDto;
import com.baanBaini.BaanBaini.user.model.entity.UserEntity;
import com.baanBaini.BaanBaini.user.repository.UserRepository;
import com.baanBaini.BaanBaini.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginServiceImplementation implements LoginService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserLoginService userLoginService;

    @Autowired
    AdminLoginService adminLoginService;
    @Autowired
    private MapperUtility mapperUtility;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

        UserDto user= userLoginService.getUserByEmailId(emailId);
        AdminDTO admin;
        UserDetails userDetails;
        if (user==null){
            admin= adminLoginService.getAdminByEmail(emailId);
            userDetails=new User(admin.getPublicAdminId(),admin.getPassword(), admin.getAuthorities());
        }
        else
            userDetails=new User(user.getPublicUserId(), user.getPassword(),user.getAuthorities());

        return userDetails;
    }

    @Override
    public UserDetails getUserByPublicId(String userId) {
        UserDto user= userLoginService.getUserByPublicId(userId);
        AdminDTO admin;
        UserDetails userDetails;
        if (user==null){
            admin= adminLoginService.getAdminByPublicUserId(userId);
            userDetails=new User(admin.getPublicAdminId(),admin.getPassword(), admin.getAuthorities());
        }
        else
            userDetails=new User(user.getPublicUserId(), user.getPassword(),user.getAuthorities());

        return userDetails;
    }
}
