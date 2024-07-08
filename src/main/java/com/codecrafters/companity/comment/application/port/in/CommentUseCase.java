package com.codecrafters.companity.comment.application.port.in;

import com.codecrafters.companity.comment.domain.CommentForCreate;
import com.codecrafters.companity.comment.domain.Comment;

public interface CommentUseCase {
    Comment add(CommentForCreate commentForCreate);
}
