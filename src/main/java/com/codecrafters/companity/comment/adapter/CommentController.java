package com.codecrafters.companity.comment.adapter;

import com.codecrafters.companity.comment.adapter.dto.request.AddCommentDto;
import com.codecrafters.companity.comment.adapter.dto.response.ResponseComment;
import com.codecrafters.companity.comment.application.port.in.CommentUseCase;
import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.comment.domain.Comment;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    private final CommentUseCase commentUseCase;
    private final PostUseCase postUseCase;
    @PostMapping
    public ResponseEntity<ResponseComment> add(@RequestBody AddCommentDto request){
        Post post = postUseCase.get(request.getPostId());
        Comment result = commentUseCase.add(request.toCommentForCreate(post, getUser()));
        return new ResponseEntity<>(ResponseComment.toDto(result), HttpStatus.CREATED);
    }

    //FIXME need to implement about get user
    private User getUser(){
        return User.builder().userId("shtjdrb").userName("노성규").nickName("안녕").build();
    }
}
