package com.codecrafters.companity.domain.user;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
public class User {
    private Long id;
    private String username;
    private String nickName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(nickName, user.nickName);
    }
}
