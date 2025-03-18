package com.example.employeedb3.dto;


import java.util.List;

public class EmployeeRequestDTO {

    private Integer empId;
    private String empName;
    private String email;
    private String password;

    private List<AddressRequestDto> address;
    private List<EducationRequestDto> education;

    public List<EducationRequestDto> getEducation() {
        return education;
    }

    public void setEducation(List<EducationRequestDto> education) {
        this.education = education;
    }

    public List<AddressRequestDto> getAddress() {
        return address;
    }

    public void setAddress(List<AddressRequestDto> address) {
        this.address = address;
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
}
