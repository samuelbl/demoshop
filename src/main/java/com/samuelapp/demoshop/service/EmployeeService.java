package com.samuelapp.demoshop.service;

import com.samuelapp.demoshop.model.Employee;
import com.samuelapp.demoshop.model.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Employee save(EmployeeDto employeeDto);
    Page<Employee> getAll(String name, Pageable page);
    Employee getById(Integer id);
    Employee update(EmployeeDto employeeDto, Integer id);
    void delete(Integer id);
}
