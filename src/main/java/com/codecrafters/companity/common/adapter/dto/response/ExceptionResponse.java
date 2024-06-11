package com.codecrafters.companity.common.adapter.dto.response;

import com.codecrafters.companity.exception.CustomException;
import lombok.Builder;
import org.springframework.http.ResponseEntity;

@Builder
public class ExceptionResponse {
    private String code;
    private String msg;

    public static ResponseEntity<ExceptionResponse> toResponseEntity(CustomException ex) {
        ResultCode errorType = ex.getResultCode();
        String message = ex.getMessage();

        return ResponseEntity
                .status(ex.getStatus())
                .body(ExceptionResponse.builder()
                        .code(errorType.getCode())
                        .msg(errorType.getMsg())
                        .build());
    }

}
