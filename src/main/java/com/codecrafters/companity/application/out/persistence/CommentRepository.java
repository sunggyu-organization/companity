package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.comment.Comment;
import com.codecrafters.companity.domain.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository {
    Comment add(Comment comment);
}
