package com.example.employeedb3.dto;

import java.util.List;

public class EmployeeResponseDTO2 {
    private Integer empId;
    private String empName;
    private String email;
    private String password;
    private List<AddressResponseDto> addresses;
    private List<EducationResponseDto> education;


    public List<AddressResponseDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressResponseDto> addresses) {
        this.addresses = addresses;
    }

    public List<EducationResponseDto> getEducation() {
        return education;
    }

    public void setEducation(List<EducationResponseDto> education) {
        this.education = education;
    }

    public List<AddressResponseDto> getAddressResponseDtos() {
        return addresses;
    }


    public void setAddressResponseDtos(List<AddressResponseDto> addressResponseDtos) {
        this.addresses = addressResponseDtos;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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



    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
