package com.samuelapp.demoshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FormErrorDto {
    private String mesage;
    private String field;
}
