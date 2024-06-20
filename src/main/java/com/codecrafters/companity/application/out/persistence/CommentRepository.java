package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.Comment.Comment;
import com.codecrafters.companity.domain.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository {
    Comment add(Comment comment);

    Page<Comment> findAllByPost(Post post, Pageable pageable);
}
