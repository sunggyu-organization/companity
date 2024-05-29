package com.codecrafters.companity.adapter.post;

import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.adapter.post.in.RequestPost;
import com.codecrafters.companity.adapter.post.out.ResponsePost;
import com.codecrafters.companity.application.in.usecase.PostUseCase;
import com.codecrafters.companity.config.mapper.CompanityObjectMapper;
import com.codecrafters.companity.config.mapper.PostMapper;
import com.codecrafters.companity.domain.post.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostUseCase postUseCase;
    private final CompanityObjectMapper mapper;
    @PostMapping("/add")
    public ResponseEntity<ResponsePost> add(@RequestBody RequestPost requestPost){
        Post result = postUseCase.add(mapper.convert(requestPost, Post.class), requestPost.getUserId());
        ResponsePost responsePost = mapper.convert(result, ResponsePost.class);
        return new ResponseEntity<>(responsePost, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ResponsePost>> getAll(@RequestBody PostCriteria criteria){
        //TODO need to implement
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePost> getDetail(@PathVariable("id") Long id){
        ResponsePost result = PostMapper.INSTANCE.serviceToResponsePost(postUseCase.findDetailById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
