package com.samuelapp.demoshop.controler;

import com.samuelapp.demoshop.exception.ResourceNotFoundException;
import com.samuelapp.demoshop.model.Employee;
import com.samuelapp.demoshop.model.dto.EmployeeDto;
import com.samuelapp.demoshop.repository.EmployeeRepository;
import com.samuelapp.demoshop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees/")
    public ResponseEntity<Employee> save(@RequestBody EmployeeDto employeeDto, UriComponentsBuilder uriBuilder){
        Employee employee = employeeService.save(employeeDto);
        URI uri = uriBuilder.path("/employees/{id}").buildAndExpand(employee.getId()).toUri();
        return  ResponseEntity.created(uri).body(employee);
    }

    @GetMapping("/employees/")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.update(employeeDto, id));
    }

}
