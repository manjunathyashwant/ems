package com.example.employeedb3.entity;

import jakarta.persistence.*;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String passClass;
    @Column(nullable = false)
    private String educationType;
    @Column(nullable = false)
    private Double grade;
    @Column(nullable = false)
    private Integer passingYear;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(Integer passingYear) {
        this.passingYear = passingYear;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassClass() {
        return passClass;
    }

    public void setPassClass(String passClass) {
        this.passClass = passClass;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }
}
