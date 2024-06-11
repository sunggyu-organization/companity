package com.codecrafters.companity.post.adapter;

import com.codecrafters.companity.post.application.port.out.persistence.PostCriteria;
import com.codecrafters.companity.post.adapter.dto.request.RequestPost;
import com.codecrafters.companity.post.adapter.dto.response.ResponsePost;
import com.codecrafters.companity.post.application.port.in.PostUseCase;
import com.codecrafters.companity.config.mapper.CompanityObjectMapper;
import com.codecrafters.companity.post.domain.Post;
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
        ResponsePost result = mapper.convert(postUseCase.findById(id), ResponsePost.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
