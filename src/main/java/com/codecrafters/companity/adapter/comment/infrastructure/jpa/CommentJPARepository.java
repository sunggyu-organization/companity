package com.codecrafters.companity.adapter.comment.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJPARepository extends JpaRepository<CommentEntity, Long> {
}
