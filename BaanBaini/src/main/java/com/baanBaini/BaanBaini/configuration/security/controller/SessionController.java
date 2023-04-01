package com.baanBaini.BaanBaini.configuration.security.controller;

import com.baanBaini.BaanBaini.configuration.security.SecurityConstants;
import com.baanBaini.BaanBaini.shared.urls.ControllerPaths;
import com.baanBaini.BaanBaini.shared.urls.actionPaths.SessionActionPath;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerPaths.LOGOUT)
public class SessionController {
    @PostMapping()
    public ResponseEntity<String> logout(HttpServletRequest request){
        String token= request.getHeader(SecurityConstants.HEADER_STRING);
        return ResponseEntity.ok("Hanji");
    }
}
