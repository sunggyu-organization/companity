package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import com.codecrafters.companity.adapter.infrastructure.jpa.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "USERS")
@Getter
public class UserEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
}
