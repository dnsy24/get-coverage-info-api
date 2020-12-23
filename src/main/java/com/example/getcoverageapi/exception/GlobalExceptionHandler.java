package com.example.getcoverageapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorMessage> exceptionHandler(NotFoundException e) {
        CustomerErrorMessage data = new CustomerErrorMessage();
        data.setMessage(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorMessage> exceptionHandler(BadRequestException e) {
        CustomerErrorMessage data = new CustomerErrorMessage();
        data.setMessage(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
