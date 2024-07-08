package com.codecrafters.companity.adapter.post;

import com.codecrafters.companity.comment.adapter.dto.response.ResponseComment;
import com.codecrafters.companity.adapter.post.dto.request.RequestForCreatingPost;
import com.codecrafters.companity.adapter.post.dto.request.RequestForUpdatingPost;
import com.codecrafters.companity.comment.application.port.out.persistence.CommentRepository;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.adapter.post.dto.response.ResponsePost;
import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.comment.domain.Comment;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.domain.post.PostForDelete;
import com.codecrafters.companity.domain.post.PostForUpdate;
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

import static com.codecrafters.companity.comment.adapter.CommentMapper.COMMENT_MAPPER;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostUseCase postUseCase;
    //user usecase
    private final PostRepository postRepository;

    private final CommentRepository commentRepository;
    @PostMapping
    public ResponseEntity<ResponsePost> add(@RequestBody RequestForCreatingPost requestPost){
        //TODO need to use user use case
        Post result = postUseCase.add(requestPost.toPostForCreate(getUser()));
        return new ResponseEntity<>(ResponsePost.toDomain(result), HttpStatus.CREATED);
    }

    private User getUser(){
        //TODO need to implement about get user
        //maybe we should use userUseCase -> userUseCase.getUser();
        return User.builder().userId("shtjdrb").userName("노성규").nickName("안녕").build();
    }

    @PutMapping
    public ResponseEntity<ResponsePost> update(@RequestBody RequestForUpdatingPost requestPost){
        PostForUpdate postForUpdate = requestPost.toPostForUpdate(getUser());
        Post result = postUseCase.update(postForUpdate);
        return new ResponseEntity<>(ResponsePost.toDomain(result), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<ResponsePost>> getList(@RequestBody PostCriteria criteria, Pageable pageable){
        Page<Post> result = postRepository.findByCriteria(criteria, pageable);
        List<ResponsePost> content = PostMapper.POST_MAPPER.toDtos(result.getContent());
        return new ResponseEntity<>(new PageImpl<>(content, result.getPageable(), result.getTotalElements()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePost> getDetail(@PathVariable("id") Long id){
        ResponsePost result = ResponsePost.toDomain(postRepository.getById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<Page<ResponseComment>> getCommentInPost(@PathVariable("id") Long postId, Pageable pageable){
        Post post = postUseCase.get(postId);
        Page<Comment> result = commentRepository.findAllByPost(post, pageable);
        List<ResponseComment> comments = COMMENT_MAPPER.toDtos(result.getContent());
        return new ResponseEntity<>(new PageImpl<>(comments, result.getPageable(), result.getTotalElements()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        postUseCase.delete(PostForDelete.builder().postId(id).owner(getUser()).build());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
