package com.codecrafters.companity.comment.adapter.infrastructure.jpa;

import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJPARepository extends JpaRepository<CommentEntity, Long> {
    Page<CommentEntity> findAllByPost(PostEntity post, Pageable pageable);
}
