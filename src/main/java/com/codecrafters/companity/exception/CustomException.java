package com.codecrafters.companity.exception;

import com.codecrafters.companity.adapter.utility.dto.response.ResultCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException{
    private final HttpStatus status;
    private final ResultCode resultCode;
    private final String message;

    public CustomException(HttpStatus status, ResultCode resultCode, String message) {
        this.status = status;
        this.resultCode = resultCode;
        this.message = message;
    }

    public CustomException(HttpStatus status, ResultCode resultCode, Throwable cause) {
        this.status = status;
        this.resultCode = resultCode;
        this.message = cause.getMessage();
    }

    public CustomException(HttpStatus status, CustomException customException) {
        this.status = status;
        this.resultCode = customException.getResultCode();
        this.message = customException.getMessage();
    }

    public CustomException(HttpStatus status, Throwable cause) {
        this.status = status;
        this.resultCode = ResultCode.UNKNOWN;
        this.message = cause.getMessage();
    }

    public CustomException(Exception exception) {
        if (exception.getClass() == CustomException.class) {
            CustomException customException = (CustomException) exception;
            this.status = customException.getStatus();
            this.resultCode = customException.getResultCode();
            this.message = customException.getMessage();
        } else {
            this.status = HttpStatus.BAD_REQUEST;
            this.resultCode = ResultCode.UNKNOWN;
            this.message = exception.getMessage();
        }
    }
}
