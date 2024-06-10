package com.codecrafters.companity.post.adapter.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<PostEntity, Long> {
}
