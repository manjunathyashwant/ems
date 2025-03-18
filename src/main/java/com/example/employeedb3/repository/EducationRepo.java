package com.example.employeedb3.repository;

import com.example.employeedb3.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education,Integer> {
}
