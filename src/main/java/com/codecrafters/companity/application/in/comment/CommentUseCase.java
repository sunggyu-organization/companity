package com.codecrafters.companity.application.in.comment;

import com.codecrafters.companity.domain.Comment.AddingComment;
import com.codecrafters.companity.domain.Comment.Comment;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;

public interface CommentUseCase {
    Comment add(AddingComment addingComment, Post post, User user);
}
