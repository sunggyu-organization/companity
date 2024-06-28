package com.codecrafters.companity.application.in.comment;

import com.codecrafters.companity.domain.comment.CommentForCreate;
import com.codecrafters.companity.domain.comment.Comment;
import com.codecrafters.companity.domain.comment.CommentForUpdate;

public interface CommentUseCase {
    Comment add(CommentForCreate commentForCreate);

    Comment update(CommentForUpdate commentForUpdate);
}
