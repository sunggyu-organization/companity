package com.codecrafters.companity.adapter.utility;

import com.codecrafters.companity.adapter.utility.dto.response.ExceptionResponse;
import com.codecrafters.companity.adapter.utility.dto.response.ResultCode;
import com.codecrafters.companity.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(basePackages = "com.codecrafters.companity")
public class ExceptionControllerAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> exceptionHandler(IllegalArgumentException e) {
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> exceptionHandler(CustomException e) {

        return ExceptionResponse.toResponseEntity(e);
    }
}
