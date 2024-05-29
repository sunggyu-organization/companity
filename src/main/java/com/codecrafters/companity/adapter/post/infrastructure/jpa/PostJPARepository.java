package com.codecrafters.companity.adapter.post.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<PostEntity, Long> {
}
