package com.samuelapp.demoshop.config.security;

import com.samuelapp.demoshop.config.security.TokenService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    public TokenAuthFilter(TokenService tokenService) {
    this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenRequest(request);
        if (tokenService.ValidateToken(token))
            tokenService.authenticateToken(token);
        filterChain.doFilter(request,response);
    }

    private String getTokenRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token==null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }

}
