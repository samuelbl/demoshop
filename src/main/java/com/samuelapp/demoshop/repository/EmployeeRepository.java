package com.samuelapp.demoshop.repository;

import com.samuelapp.demoshop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
