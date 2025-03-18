package com.example.employeedb3.exception;

public class InvalidCredentialsException extends RuntimeException {
    private String message;
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
