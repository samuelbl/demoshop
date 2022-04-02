package com.samuelapp.demoshop.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private Integer idEmployeType;
    private Integer idShop;
    private String telephone;
    private String address;
    private Date employmentDate;
}
