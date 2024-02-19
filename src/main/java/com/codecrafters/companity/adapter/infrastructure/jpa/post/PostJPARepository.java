package com.codecrafters.companity.adapter.infrastructure.jpa.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<PostEntity, Long> {
}
