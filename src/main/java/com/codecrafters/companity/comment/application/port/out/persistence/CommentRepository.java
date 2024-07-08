package com.codecrafters.companity.comment.application.port.out.persistence;

import com.codecrafters.companity.comment.domain.Comment;
import com.codecrafters.companity.domain.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository {
    Comment add(Comment comment);
    Page<Comment> findAllByPost(Post post, Pageable pageable);

    Comment update(Comment comment);

    Comment getById(Long id);
}
