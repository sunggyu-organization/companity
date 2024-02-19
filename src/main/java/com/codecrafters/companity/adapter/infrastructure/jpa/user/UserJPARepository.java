package com.codecrafters.companity.adapter.infrastructure.jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
}
