package com.samuelapp.demoshop.service;

import com.samuelapp.demoshop.exception.ResourceNotFoundException;
import com.samuelapp.demoshop.model.Employee;
import com.samuelapp.demoshop.model.dto.EmployeeDto;
import com.samuelapp.demoshop.repository.EmployeeRepository;
import com.samuelapp.demoshop.util.EmployeeDtoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDtoMapper employeeDtoMapper;

    @Override
    public Employee save(EmployeeDto employeeDto) {
        return employeeRepository.save(employeeDtoMapper.employeDtoToEmployee(employeeDto));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee not found "+id));
    }

    @Override
    public Employee update(EmployeeDto employeeDto, Integer id) {
        Employee employee = employeeDtoMapper.employeDtoToEmployee(employeeDto);
        return employeeRepository.findById(id)
                .map(record -> {
                    BeanUtils.copyProperties(employee, record, "id");
                    return employeeRepository.save(record);
                }).orElseThrow(
                ()->new ResourceNotFoundException("Employee not found "+id));
    }

    @Override
    public void delete(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee not found "+id));
        employeeRepository.delete(employee);
    }
}
