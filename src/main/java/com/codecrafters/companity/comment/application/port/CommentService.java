package com.codecrafters.companity.comment.application.port;

import com.codecrafters.companity.comment.application.port.in.CommentUseCase;
import com.codecrafters.companity.comment.application.port.out.persistence.CommentRepository;
import com.codecrafters.companity.comment.domain.CommentForCreate;
import com.codecrafters.companity.comment.domain.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService implements CommentUseCase {
    private final CommentRepository commentRepository;
    @Override
    public Comment add(CommentForCreate commentForCreate) {
        Comment comment = commentForCreate.toComment();
        return commentRepository.add(comment);
    }
}
