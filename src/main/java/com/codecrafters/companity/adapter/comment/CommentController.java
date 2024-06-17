package com.codecrafters.companity.adapter.comment;

import com.codecrafters.companity.adapter.comment.dto.request.AddedCommentDto;
import com.codecrafters.companity.adapter.comment.dto.response.ResponseComment;
import com.codecrafters.companity.application.in.comment.CommentUseCase;
import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.domain.Comment.Comment;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.codecrafters.companity.adapter.comment.CommentMapper.COMMENT_MAPPER;
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    private final CommentUseCase commentUseCase;
    private final PostUseCase postUseCase;
    @PostMapping
    public ResponseEntity<ResponseComment> add(@RequestBody AddedCommentDto request){
        //TODO need to use user use case
        User user = getUser();
        Post post = postUseCase.get(request.getPostId());
        Comment result = commentUseCase.add(request.toAddingComment(), post, user);
        ResponseComment responsePost = COMMENT_MAPPER.toDto(result);
        return new ResponseEntity<>(responsePost, HttpStatus.OK);
    }

    private User getUser(){
        //FIXME need to implement about get user
        //maybe we should use userUseCase -> userUseCase.getUser();
        return User.builder().userId("shtjdrb").userName("노성규").nickName("안녕").build();
    }
}
