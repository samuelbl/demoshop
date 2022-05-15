package com.samuelapp.demoshop.config.security;

import com.samuelapp.demoshop.model.User;
import com.samuelapp.demoshop.repository.UserRepository;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TokenService {

    @Value("${demoshop.jwt.expiration}")
    private String expiration;

    @Value("${demoshop.jwt.secret}")
    private String secret;

    @Autowired
    UserRepository userRepository;

    public String buildToken(Authentication authenticate) {
        User user = (User) authenticate.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date(today.getTime()+Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API demoShop")
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public Boolean ValidateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void authenticateToken(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Optional<User> optionalUser = userRepository.findById(Integer.valueOf(body.getSubject()));
        User user = optionalUser.orElseThrow(()-> new UsernameNotFoundException("User not found"));
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
