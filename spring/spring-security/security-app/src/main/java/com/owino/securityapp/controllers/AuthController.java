package com.owino.securityapp.controllers;

import com.owino.securityapp.auth.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/token")
    public String getToken(Authentication authentication){
        return tokenService.generateToken(authentication);
    }
}
