package com.samuelapp.demoshop.service;

import com.samuelapp.demoshop.config.security.TokenService;
import com.samuelapp.demoshop.model.dto.LoginDto;
import com.samuelapp.demoshop.model.dto.TokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Override
    public TokenDto Authenticate(LoginDto loginDto) {
        UsernamePasswordAuthenticationToken loginData = new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword());
        TokenDto tokenDto = new TokenDto(new String(), "Bearer");
        try {
            Authentication authenticate = authenticationManager.authenticate(loginData);
            tokenDto.setToken(tokenService.buildToken(authenticate));
        } catch (AuthenticationException e) {
            throw new UsernameNotFoundException("Bad Credentials");
        }
        return tokenDto;
    }
}
