package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "USERS")
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
}
