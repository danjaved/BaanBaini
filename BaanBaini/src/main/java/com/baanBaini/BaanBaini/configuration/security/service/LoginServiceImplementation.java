package com.baanBaini.BaanBaini.configuration.security.service;

import com.baanBaini.BaanBaini.user.model.entity.UserEntity;
import com.baanBaini.BaanBaini.user.repository.UserRepository;
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

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        UserEntity userEntity= userRepository.findByEmail(emailId);
        User user = new User(userEntity.getPublicUserId(),userEntity.getPassword(), new ArrayList<>());
        return user;
    }
}
