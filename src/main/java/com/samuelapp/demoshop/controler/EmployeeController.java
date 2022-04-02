package com.samuelapp.demoshop.controler;

import com.samuelapp.demoshop.exception.ResourceNotFoundException;
import com.samuelapp.demoshop.model.Employee;
import com.samuelapp.demoshop.repository.EmployeeRepository;
import com.samuelapp.demoshop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employess/")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/employess/")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/employess/{id}")
    public ResponseEntity<Employee> findById(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok().body(employeeService.getById(id));
    }

    @DeleteMapping("/employess/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Integer id){
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/employes/{id}")
    public ResponseEntity<Employee> update(@PathVariable(value = "id") Integer id,
                                           @RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.update(employee, id));
    }

}
