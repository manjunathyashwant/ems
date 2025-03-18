package com.example.employeedb3.exception;

import com.example.employeedb3.dto.ResponseDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler( EmployeeFoundException.class)
    public ResponseDTO employeeFoundException(EmployeeFoundException e){
        return new ResponseDTO(true,e.getMessage(),null);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseDTO employeeNotFoundException(EmployeeNotFoundException e){
        return new ResponseDTO(true,e.getMessage(),null);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseDTO invalidCredentials(InvalidCredentialsException e){
        return new ResponseDTO(true,e.getMessage(),null);
    }
}
