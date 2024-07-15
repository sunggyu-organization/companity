package com.codecrafters.companity.comment.application.port;

import com.codecrafters.companity.comment.application.port.in.CommentUseCase;
import com.codecrafters.companity.comment.application.port.out.persistence.CommentRepository;
import com.codecrafters.companity.comment.domain.CommentForCreate;
import com.codecrafters.companity.comment.domain.Comment;
import com.codecrafters.companity.comment.domain.CommentForUpdate;
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
        //TODO : change to use commentForCreate directly and validate here
        Comment comment = commentForCreate.toComment();
        return commentRepository.add(comment);
    }

    @Override
    public Comment update(CommentForUpdate commentForUpdate) {
        Comment comment = commentRepository.getById(commentForUpdate.getId());
        return commentRepository.update(commentForUpdate.update(comment));
    }
}
