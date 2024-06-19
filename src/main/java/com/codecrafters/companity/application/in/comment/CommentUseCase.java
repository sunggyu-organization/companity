package com.codecrafters.companity.application.in.comment;

import com.codecrafters.companity.domain.Comment.AddingComment;
import com.codecrafters.companity.domain.Comment.Comment;

public interface CommentUseCase {
    Comment add(AddingComment addingComment);
}
