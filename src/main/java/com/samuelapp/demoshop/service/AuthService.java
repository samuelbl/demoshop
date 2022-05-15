package com.samuelapp.demoshop.service;

import com.samuelapp.demoshop.model.dto.LoginDto;
import com.samuelapp.demoshop.model.dto.TokenDto;

public interface AuthService {
    TokenDto Authenticate(LoginDto loginDto);
}
