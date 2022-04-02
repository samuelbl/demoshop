package com.samuelapp.demoshop.service;

import com.samuelapp.demoshop.model.Employee;
import com.samuelapp.demoshop.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    Employee save(EmployeeDto employeeDto);
    List<Employee> getAll();
    Employee getById(Integer id);
    Employee update(EmployeeDto employeeDto, Integer id);
    void delete(Integer id);
}
