package com.codecrafters.companity.adapter.user.infrastructure.jpa;

import jakarta.persistence.Column;
import lombok.Getter;

import com.codecrafters.companity.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "USERS")
@Getter
@NoArgsConstructor
public class UserEntity {
    @Id
    private String userId;

    @Column(nullable = false)
    private String userName;
    private String nickName;

    public static UserEntity from(User user) {
        return UserEntity.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .nickName(user.getNickName())
                .build();
    }

    @Builder
    public UserEntity(String userId, String userName, String nickName) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
    }

    public User toDomain() {
        return User.builder()
                .userId(this.userId)
                .userName(this.userName)
                .nickName(this.nickName)
                .build();
    }
}
