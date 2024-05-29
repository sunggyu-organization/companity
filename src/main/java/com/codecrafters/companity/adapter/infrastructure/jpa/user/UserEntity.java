package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import com.codecrafters.companity.adapter.infrastructure.jpa.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "USERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
}
