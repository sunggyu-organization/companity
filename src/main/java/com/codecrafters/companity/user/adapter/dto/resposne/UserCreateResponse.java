package com.codecrafters.companity.user.adapter.dto.resposne;


import com.codecrafters.companity.user.domain.User;
import lombok.Getter;

@Getter
public class UserCreateResponse {
    private final String userId;
    private final String userName;
    private final String nickName;

    public UserCreateResponse(String userId, String userName, String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
    }

    public static UserCreateResponse from(User user) {
        return new UserCreateResponse(user.getUserId(), user.getUserName(), user.getNickName());
    }
}
