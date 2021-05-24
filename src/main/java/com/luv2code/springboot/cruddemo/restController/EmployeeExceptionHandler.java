package com.luv2code.springboot.cruddemo.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> notFoundException(EmployeeNotFound exception) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }
}
