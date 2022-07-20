package com.baanBaini.BaanBaini.user.serviceImplementation;

import com.baanBaini.BaanBaini.shared.utility.MapperUtility;
import com.baanBaini.BaanBaini.shared.utility.Utility;
import com.baanBaini.BaanBaini.user.model.dto.UserDto;
import com.baanBaini.BaanBaini.user.model.entity.UserEntity;
import com.baanBaini.BaanBaini.user.repository.UserRepository;
import com.baanBaini.BaanBaini.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserLoginServiceImplementation implements UserLoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapperUtility mapperUtility;
    @Autowired
    private Utility utility;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto addUser(UserDto user) {
        user.setPublicUserId(utility.getRandomString(12));
        UserEntity userEntity= mapperUtility.mapModel(user, UserEntity.class);
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setAccountEnabled(true);
        ArrayList<String> auths=new ArrayList<>();
        auths.add("ROLE_User");
        userEntity.setAuthorities(auths);
        userEntity=this.userRepository.save(userEntity);
        user = mapperUtility.mapModel(userEntity, UserDto.class);
        return user;
    }

    @Override
    public UserDto getUserByEmailId(String emailId) {
        return mapperUtility.mapModel(userRepository.findByEmail(emailId),UserDto.class);
    }


    @Override
    public UserDto getUserByPublicId(String userId) {
        return mapperUtility.mapModel(userRepository.findByPublicUserId(userId),UserDto.class);
    }

}
