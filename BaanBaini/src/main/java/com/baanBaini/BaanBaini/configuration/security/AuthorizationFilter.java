package com.baanBaini.BaanBaini.configuration.security;

import com.baanBaini.BaanBaini.SpringApplicationContext;
import com.baanBaini.BaanBaini.configuration.security.service.LoginService;
import com.baanBaini.BaanBaini.user.model.dto.UserDto;
import com.baanBaini.BaanBaini.user.service.UserLoginService;
import io.jsonwebtoken.Jwts;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import java.io.IOException;
import java.util.ArrayList;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header=request.getHeader(SecurityConstants.HEADER_STRING);
        if(header==null || ! header.startsWith(SecurityConstants.TOKEN_PREFIX)){
            chain.doFilter(request,response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken=getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);
    }
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        LoginService loginService = (LoginService)SpringApplicationContext.getBean("loginServiceImplementation");

        String token = request.getHeader(SecurityConstants.HEADER_STRING);

        try{
            if (token != null) {
                token = token.replace(SecurityConstants.TOKEN_PREFIX, "");
                String publicUserId=Jwts.parserBuilder().setSigningKey(SecurityConstants.getTokenSecret()).build().parseClaimsJws(token).getBody()
                        .getSubject();
                UserDetails userDetails= loginService.getUserByPublicId(publicUserId);
                if (publicUserId != null && userDetails!=null) {
                    return new UsernamePasswordAuthenticationToken(publicUserId, userDetails.getPassword(), userDetails.getAuthorities());
                }
            }
        }catch (Exception e){

        }
        return new UsernamePasswordAuthenticationToken("","",new ArrayList<>());
    }
}


