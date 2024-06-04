package com.codecrafters.companity.domain.user;

import com.codecrafters.companity.adapter.user.dto.request.UserCreateRequest;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private String userId;
    private String userName;
    private String nickName;

    public static User from(UserCreateRequest request) {
        return new User(request.getUserId(), request.getUserName(), request.getNickName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName) && Objects.equals(nickName, user.nickName);
    }

    public void validateUser() {
        if (this.userId == null) throw new IllegalArgumentException("userId is required.");
        if (this.userName == null) throw  new IllegalArgumentException("userName is required.");
    }

    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }
}
