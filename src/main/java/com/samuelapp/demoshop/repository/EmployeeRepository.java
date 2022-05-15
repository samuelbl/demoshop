package com.samuelapp.demoshop.repository;

import com.samuelapp.demoshop.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Optional<Page<Employee>> findByNameContainingIgnoreCase(String name, Pageable pag);
}
