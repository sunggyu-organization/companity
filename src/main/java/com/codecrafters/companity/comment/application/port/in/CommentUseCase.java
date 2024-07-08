package com.codecrafters.companity.comment.application.port.in;

import com.codecrafters.companity.comment.domain.CommentForCreate;
import com.codecrafters.companity.comment.domain.Comment;
import com.codecrafters.companity.comment.domain.CommentForUpdate;

public interface CommentUseCase {
    Comment add(CommentForCreate commentForCreate);

    Comment update(CommentForUpdate commentForUpdate);
}
