package com.codecrafters.companity.user.adapter.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, String> {
}
