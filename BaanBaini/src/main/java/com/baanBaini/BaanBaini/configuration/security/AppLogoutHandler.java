package com.baanBaini.BaanBaini.configuration.security;

import com.baanBaini.BaanBaini.SpringApplicationContext;
import com.baanBaini.BaanBaini.configuration.security.service.ActiveTokenService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class AppLogoutHandler implements LogoutHandler
{
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        ActiveTokenService activeTokenService = (ActiveTokenService) SpringApplicationContext.getBean("activeTokenServiceImplementation");

        String token= request.getHeader(SecurityConstants.HEADER_STRING);
        if (token != null) {
            token = token.replace(SecurityConstants.TOKEN_PREFIX, "");
            String publicUserId= Jwts.parserBuilder().setSigningKey(SecurityConstants.getTokenSecret()).build().parseClaimsJws(token).getBody()
                    .getSubject();
            activeTokenService.removeToken(publicUserId,token);
        }
    }
}
