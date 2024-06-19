package com.codecrafters.companity.application.service.comment;

import com.codecrafters.companity.application.in.comment.CommentUseCase;
import com.codecrafters.companity.application.out.persistence.CommentRepository;
import com.codecrafters.companity.domain.Comment.AddingComment;
import com.codecrafters.companity.domain.Comment.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService implements CommentUseCase {
    private final CommentRepository commentRepository;
    @Override
    public Comment add(AddingComment addingComment) {
        Comment comment = addingComment.toComment();
        return commentRepository.add(comment);
    }
}
