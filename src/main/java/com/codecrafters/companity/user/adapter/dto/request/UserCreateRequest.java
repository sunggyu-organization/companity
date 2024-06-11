package com.codecrafters.companity.user.adapter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class UserCreateRequest {
    private final String userId;
    private final String userName;
    private final String nickName;

    public UserCreateRequest(@JsonProperty("userId") String userId, @JsonProperty("userName") String userName, @JsonProperty("nickName") String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
    }
}
