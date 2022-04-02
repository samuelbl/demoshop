package com.samuelapp.demoshop.model.dto;

import com.samuelapp.demoshop.model.EmployeeType;
import com.samuelapp.demoshop.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
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
