package com.codecrafters.companity.adapter.comment;

import com.codecrafters.companity.adapter.comment.dto.request.AddCommentDto;
import com.codecrafters.companity.adapter.comment.dto.response.ResponseComment;
import com.codecrafters.companity.application.in.comment.CommentUseCase;
import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.application.out.persistence.CommentRepository;
import com.codecrafters.companity.domain.Comment.Comment;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.codecrafters.companity.adapter.comment.CommentMapper.COMMENT_MAPPER;
@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    private final CommentUseCase commentUseCase;

    private final CommentRepository commentRepository;
    private final PostUseCase postUseCase;
    @PostMapping
    public ResponseEntity<ResponseComment> add(@RequestBody AddCommentDto request){
        Post post = postUseCase.get(request.getPostId());
        Comment result = commentUseCase.add(request.toAddingComment(post, getUser()));
        ResponseComment responsePost = COMMENT_MAPPER.toDto(result);
        return new ResponseEntity<>(responsePost, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<ResponseComment>> getList(@PathVariable("id") Long postId, Pageable pageable){
        Post post = postUseCase.get(postId);
        Page<Comment> result = commentRepository.findAllByPost(post, pageable);
        List<ResponseComment> content = COMMENT_MAPPER.toDtos(result.getContent());
        return new ResponseEntity<>(new PageImpl<>(content, result.getPageable(), result.getTotalElements()), HttpStatus.OK);
    }

    //FIXME need to implement about get user
    private User getUser(){
        return User.builder().userId("shtjdrb").userName("노성규").nickName("안녕").build();
    }
}
