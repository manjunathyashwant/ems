package com.example.employeedb3.repository;

import com.example.employeedb3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
   Optional<Employee> findByEmail(String email);
}
