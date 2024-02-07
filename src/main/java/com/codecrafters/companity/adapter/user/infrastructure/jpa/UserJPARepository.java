package com.codecrafters.companity.adapter.user.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
}
