package com.samuelapp.demoshop.controler;

import com.samuelapp.demoshop.model.dto.LoginDto;
import com.samuelapp.demoshop.model.dto.TokenDto;
import com.samuelapp.demoshop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginDto loginDto){
        TokenDto token = authService.Authenticate(loginDto);
        return ResponseEntity.ok(token);
    }
}
