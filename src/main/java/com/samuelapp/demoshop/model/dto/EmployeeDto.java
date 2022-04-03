package com.samuelapp.demoshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
    private String name;
    private Integer idEmployeType;
    private Integer idShop;
    private String telephone;
    private String address;
    private LocalDate employmentDate;
}
