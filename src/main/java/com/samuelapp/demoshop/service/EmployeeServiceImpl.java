package com.samuelapp.demoshop.service;

import com.samuelapp.demoshop.exception.ResourceNotFoundException;
import com.samuelapp.demoshop.model.Employee;
import com.samuelapp.demoshop.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee not found "+id));
        return employee;
    }

    @Override
    public Employee update(Employee employee, Integer id) {
        return employeeRepository.findById(id)
                .map(record -> {
                    record.setAddress(employee.getAddress());
                    record.setEmploymentDate(employee.getEmploymentDate());
                    record.setName(employee.getName());
                    record.setShop(employee.getShop());
                    record.setTelephone(employee.getTelephone());
                    record.setType(employee.getType());
                    Employee updated = employeeRepository.save(record);
                    return updated;
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
