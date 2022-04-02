package com.samuelapp.demoshop.service;

import com.samuelapp.demoshop.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> getAll();
    Employee getById(Integer id);
    Employee update(Employee employee, Integer id);
    void delete(Integer id);
}
