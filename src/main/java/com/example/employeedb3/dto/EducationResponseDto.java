package com.example.employeedb3.dto;

import com.example.employeedb3.entity.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class EducationResponseDto {
    private Integer id;
    private String passClass;
    private String educationType;
    private Double grade;
    private Integer passingYear;

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

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(Integer passingYear) {
        this.passingYear = passingYear;
    }
}
