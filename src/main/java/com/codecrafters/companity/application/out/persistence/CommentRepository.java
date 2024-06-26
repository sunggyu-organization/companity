package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.comment.Comment;

public interface CommentRepository {
    Comment add(Comment comment);
}
