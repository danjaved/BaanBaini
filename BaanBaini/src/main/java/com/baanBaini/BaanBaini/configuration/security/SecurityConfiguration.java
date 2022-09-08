package com.baanBaini.BaanBaini.configuration.security;

import com.baanBaini.BaanBaini.configuration.security.service.LoginService;
import com.baanBaini.BaanBaini.shared.urls.ControllerPaths;
import com.baanBaini.BaanBaini.user.service.UserLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final LoginService loginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public SecurityConfiguration(LoginService loginService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.loginService = loginService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder=http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(loginService).passwordEncoder(bCryptPasswordEncoder);
        AuthenticationManager authenticationManager=authenticationManagerBuilder.build();

        http.csrf().disable().authorizeHttpRequests()
                .antMatchers("/**/login").permitAll()
                .antMatchers("/**/signup").permitAll()
                .antMatchers(ControllerPaths.HOME_BASE_PATH+"/**").permitAll()
                .antMatchers(HttpMethod.GET,ControllerPaths.KURTIS_BASE_PATH+"/**").permitAll()
                .antMatchers(ControllerPaths.KURTIS_BASE_PATH+"/**").hasAuthority("ROLE_Admin")
                .antMatchers(ControllerPaths.USER_BASE_URL+"/**").hasAuthority("ROLE_User")
                .antMatchers(ControllerPaths.ADMIN_BASE_URL+"/**").hasAuthority("ROLE_Admin")
                .anyRequest().authenticated().and()
                .addFilter(getAuthenticationFilter(authenticationManager))
                .addFilter(new AuthorizationFilter(authenticationManager))
                .authenticationManager(authenticationManager).cors().configurationSource(corsConfigurationSource()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    public AuthenticationFilter getAuthenticationFilter(AuthenticationManager authenticationManager) throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager);
        filter.setFilterProcessesUrl("/login");
        return filter;
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setExposedHeaders(Arrays.asList("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
