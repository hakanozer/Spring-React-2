package com.works.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid( MethodArgumentNotValidException ex ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", false);
        hm.put("result", ex.getFieldErrors());
        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }

}

/*
{
    "status": false,
    "result": [
    {
        "field": "title",
        "defaultMessage": "boş değer olamaz",
        "code": "NotEmpty"
    },
    {
        "field": "price",
        "defaultMessage": "boş değer olamaz",
        "code": "NotEmpty"
    }
    ]
}
 */
