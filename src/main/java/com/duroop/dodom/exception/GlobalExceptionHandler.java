package com.duroop.dodom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = BusinessException.class)
    protected ResponseEntity<ExceptionResponse> handleCustomException(BusinessException e) {
        ExceptionResponse response = ExceptionResponse.of(e.getExceptionCode());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
