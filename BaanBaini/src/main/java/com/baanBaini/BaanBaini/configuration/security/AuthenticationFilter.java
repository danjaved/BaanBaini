package com.baanBaini.BaanBaini.configuration.security;


import com.baanBaini.BaanBaini.SpringApplicationContext;
import com.baanBaini.BaanBaini.user.model.dto.UserDto;
import com.baanBaini.BaanBaini.user.model.requestModel.UserLogInRequestModel;
import com.baanBaini.BaanBaini.user.service.UserLoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;



    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        UserLogInRequestModel cred;
        try {
            cred = new ObjectMapper().readValue(request.getInputStream(),
                    UserLogInRequestModel.class);

            return authenticationManager.authenticate( new
                    UsernamePasswordAuthenticationToken(cred.getEmail(), cred.getPassword(), new
                    ArrayList<>()));

        } catch (Exception e) {
            throw new RuntimeException();
        }
        //return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cred.getEmail(), cred.getPassword(), new ArrayList<>()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
//        ErrorResponseMessage error=new ErrorResponseMessage(new Date(), "Invalid Credentials");
//        super.unsuccessfulAuthentication(request, response, failed);
//        throw new InvalidCredentialsException("Invalid Credentials");
        super.unsuccessfulAuthentication(request,response,failed);

    }
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String userName = ((User) authResult.getPrincipal()).getUsername();
        String token =null;

        try{
            token = Jwts.builder().setSubject(userName)
                    .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret()).compact();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        Object userLoginServiceObject=SpringApplicationContext.getBean("userLoginServiceImplementation");
        UserLoginService userService = (UserLoginService) userLoginServiceObject;
        UserDto userDto=userService.getUserByEmailId(userName);
        String userId = userDto.getPublicUserId();
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        response.addHeader("UserId", userId);
    }
}
