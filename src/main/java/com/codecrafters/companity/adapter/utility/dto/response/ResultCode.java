package com.codecrafters.companity.adapter.utility.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {
    UNKNOWN("UNKNOWN", "unchecked exception"),
    USER_NOT_FOUND("USER_NOT_FOUND", "user not found exception.");

    private final String code;
    private final String msg;
}
