package com.works.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNot(MethodArgumentNotValidException ex ) {
        return new ResponseEntity(ex.getFieldErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArithmeticException.class)
    public String test() {
        return "ArithmeticException  - Test Fail";
    }

    @ExceptionHandler(Exception.class)
    public String test_1() {
        return "Exception - Test Fail";
    }

}
