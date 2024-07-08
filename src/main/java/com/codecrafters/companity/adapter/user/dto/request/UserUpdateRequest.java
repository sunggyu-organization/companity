package com.codecrafters.companity.adapter.user.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * UserId는 PK이므로 변경되지 않는다.
 */
@Getter
public class UserUpdateRequest {
    private final String userName;
    private final String nickName;

    public UserUpdateRequest(@JsonProperty("userName") String userName, @JsonProperty("nickName") String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }

}
