package com.example.employeedb3.controller;

import com.example.employeedb3.dto.EmployeeRequestDTO;
import com.example.employeedb3.dto.EmployeeResponseDTO2;
import com.example.employeedb3.dto.ResponseDTO;
import com.example.employeedb3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public ResponseDTO addEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){

      //  return service.addEmp(employeeDTO);
        return new ResponseDTO(false,"employee added successfully",service.addEmp(employeeRequestDTO)) ;
    }
    @GetMapping ("/getEmployee")
    public ResponseDTO getEmployee(EmployeeResponseDTO2 employeeDTO){
        return new ResponseDTO(false,"employee fetched successfully", service.getAllEmployee());
    }
    @PostMapping ("/delete")
    public String deleteEmployee(@RequestParam ("email")String email,@RequestParam ("password")String password){
        return service.deleteEMployee(email,password);
    }
    @PostMapping("/update")
    public ResponseDTO updateEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){

        return new ResponseDTO(false,"Employee updated successfully",  service.updateEmployeeByEmail(employeeRequestDTO));
    }

    @PostMapping("/login")
    public ResponseDTO login(@RequestParam ("email")String email,@RequestParam("password")String password){


        return new ResponseDTO(false,"login successful", service.loginEmployee(email,password));
    }
    @GetMapping("/fetch/{email}")      //way to write path variable
    public ResponseDTO getByEmail(@PathVariable String email){
        return new ResponseDTO(false,"employee fetched successfully",service.fetchEmployee(email));
    }

}
