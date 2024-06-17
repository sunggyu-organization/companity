package com.codecrafters.companity.adapter.post;

import com.codecrafters.companity.adapter.post.dto.request.RequestForCreatingPost;
import com.codecrafters.companity.adapter.post.dto.request.RequestForUpdatingPost;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.adapter.post.dto.response.ResponsePost;
import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.application.out.persistence.PostRepository;
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

import static com.codecrafters.companity.adapter.post.PostMapper.POST_MAPPER;


@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostUseCase postUseCase;
    //user usecase
    private final PostRepository postRepository;
    @PostMapping
    public ResponseEntity<ResponsePost> add(@RequestBody RequestForCreatingPost requestPost){
        //TODO need to use user use case
        User user = getUser();
        Post result = postUseCase.add(requestPost.toPostCreateDto(), user);
        ResponsePost responsePost = POST_MAPPER.toDto(result);
        return new ResponseEntity<>(responsePost, HttpStatus.OK);
    }

    private User getUser(){
        //TODO need to implement about get user
        //maybe we should use userUseCase -> userUseCase.getUser();
        return User.builder().userId("shtjdrb").userName("노성규").nickName("안녕").build();
    }

    @PutMapping
    public ResponseEntity<ResponsePost> update(@RequestBody RequestForUpdatingPost requestPost){
        Post result = postUseCase.update(requestPost.toPostUpdateDto());
        ResponsePost responsePost = POST_MAPPER.toDto(result);
        return new ResponseEntity<>(responsePost, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<ResponsePost>> getList(@RequestBody PostCriteria criteria, Pageable pageable){
        Page<Post> result = postRepository.findByCriteria(criteria, pageable);
        List<ResponsePost> content = POST_MAPPER.toDtos(result.getContent());
        return new ResponseEntity<>(new PageImpl<>(content, result.getPageable(), result.getTotalElements()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePost> getDetail(@PathVariable("id") Long id){
        ResponsePost result = POST_MAPPER.toDto(postUseCase.get(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        postRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
