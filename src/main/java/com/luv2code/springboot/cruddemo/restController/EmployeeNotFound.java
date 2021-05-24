package com.luv2code.springboot.cruddemo.restController;

public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(String message) {
        super(message);
    }

    public EmployeeNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFound(Throwable cause) {
        super(cause);
    }

}
