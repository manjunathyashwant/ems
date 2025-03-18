package com.example.employeedb3.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee_table")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    @Column(name = "employee_name", length = 50)
    private String empName;
    @Column(unique = true, length = 50)
    private String email;
    @Column(name = "employee_password", length = 50)
    private String password;





    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
