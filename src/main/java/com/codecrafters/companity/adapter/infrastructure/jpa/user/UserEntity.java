package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "USERS")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String name;
}
