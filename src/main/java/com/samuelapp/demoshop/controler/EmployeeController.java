package com.samuelapp.demoshop.controler;

import com.samuelapp.demoshop.exception.ResourceNotFoundException;
import com.samuelapp.demoshop.model.Employee;
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

    @PostMapping("/employess/")
    public ResponseEntity<Employee> save(@RequestBody Employee employee, UriComponentsBuilder uriBuilder){
        URI uri = uriBuilder.path("/employees/{id}").buildAndExpand(employee.getId()).toUri();
        return  ResponseEntity.created(uri).body(employeeService.save(employee));
    }

    @GetMapping("/employess/")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/employess/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Integer id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @DeleteMapping("/employess/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/employes/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.update(employee, id));
    }

}
