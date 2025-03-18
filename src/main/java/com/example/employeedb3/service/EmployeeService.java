package com.example.employeedb3.service;

import com.example.employeedb3.dto.EmployeeRequestDTO;
import com.example.employeedb3.dto.EmployeeResponseDTO2;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO2 addEmp(EmployeeRequestDTO employeeRequestDTO);

    List<EmployeeResponseDTO2> getAllEmployee();



    String deleteEMployee(String email,String password);

    String addByEmail(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO2 updateEmployeeByEmail(EmployeeRequestDTO employeeRequestDTO);

    EmployeeResponseDTO2 loginEmployee(String email, String password);

    EmployeeResponseDTO2 fetchEmployee(String email);
    //  Employee getEmployeeByEmail(String email);
}
