package com.samuelapp.demoshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class TokenDto {
    private String token;
    private String tipo;
}
