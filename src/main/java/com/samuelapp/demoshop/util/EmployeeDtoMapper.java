package com.samuelapp.demoshop.util;

import com.samuelapp.demoshop.exception.ResourceNotFoundException;
import com.samuelapp.demoshop.model.Employee;
import com.samuelapp.demoshop.model.EmployeeType;
import com.samuelapp.demoshop.model.Shop;
import com.samuelapp.demoshop.model.dto.EmployeeDto;
import com.samuelapp.demoshop.repository.EmployeeTypeRepository;
import com.samuelapp.demoshop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoMapper {

    @Autowired
    EmployeeTypeRepository employeeTypeRepository;

    @Autowired
    ShopRepository shopRepository;

    public Employee employeDtoToEmployee(EmployeeDto employeeDto) {
        Shop shop = shopRepository.findById(employeeDto.getIdShop()).orElseThrow(
                ()-> new ResourceNotFoundException("Shop not found " + employeeDto.getIdShop()));
        EmployeeType employeeType = employeeTypeRepository.findById(employeeDto.getIdEmployeType()).orElseThrow(
                ()-> new ResourceNotFoundException("EmployeeType not found " + employeeDto.getIdEmployeType()));
        return Employee.builder()
                .address(employeeDto.getAddress())
                .employmentDate(employeeDto.getEmploymentDate())
                .telephone(employeeDto.getTelephone())
                .name(employeeDto.getName())
                .type(employeeType)
                .shop(shop)
                .build();
    }
}
