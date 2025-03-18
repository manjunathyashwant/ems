package com.example.employeedb3.exception;

public class EmployeeFoundException extends RuntimeException{
    private String message;
    public EmployeeFoundException(String message){
        super(message);
    }
}
