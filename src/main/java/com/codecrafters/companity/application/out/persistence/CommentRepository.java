package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.Comment.Comment;

public interface CommentRepository {
    Comment add(Comment comment);
}
