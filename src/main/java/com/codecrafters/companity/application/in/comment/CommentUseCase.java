package com.codecrafters.companity.application.in.comment;

import com.codecrafters.companity.domain.comment.AddingComment;
import com.codecrafters.companity.domain.comment.Comment;

public interface CommentUseCase {
    Comment add(AddingComment addingComment);
}
