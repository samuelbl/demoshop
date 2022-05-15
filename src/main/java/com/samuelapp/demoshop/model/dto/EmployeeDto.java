package com.samuelapp.demoshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String name;
    @NotNull
    private Integer idEmployeeType;
    @NotNull
    private Integer idShop;
    private String telephone;
    private String address;
    private LocalDate employmentDate;
}
