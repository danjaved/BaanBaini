package com.baanBaini.BaanBaini.configuration.security;

import com.baanBaini.BaanBaini.SpringApplicationContext;
import com.baanBaini.BaanBaini.user.service.UserLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.concurrent.atomic.AtomicBoolean;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final UserLoginService userLoginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public SecurityConfiguration(UserLoginService userLoginService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userLoginService = userLoginService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder=http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userLoginService).passwordEncoder(bCryptPasswordEncoder);
        AuthenticationManager authenticationManager=authenticationManagerBuilder.build();

        http.csrf().disable().authorizeRequests()
                .antMatchers("/**/login").permitAll()
                .antMatchers("/**/signup").permitAll()
                .antMatchers("/home/**").permitAll()
                .anyRequest().authenticated().and()
                .addFilter(getAuthenticationFilter(authenticationManager))
                .addFilter(new AuthorizationFilter(authenticationManager))
                .authenticationManager(authenticationManager)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    public AuthenticationFilter getAuthenticationFilter(AuthenticationManager authenticationManager) throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager);
        filter.setFilterProcessesUrl("/user/login");
        return filter;
    }
}
