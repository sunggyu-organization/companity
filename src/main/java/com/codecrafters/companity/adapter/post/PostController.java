package com.codecrafters.companity.adapter.post;

import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.adapter.post.in.RequestPost;
import com.codecrafters.companity.adapter.post.out.ResponsePost;
import com.codecrafters.companity.application.in.usecase.PostUseCase;
import com.codecrafters.companity.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostUseCase postUseCase;
    @PostMapping("/add")
    public ResponseEntity<ResponsePost> add(@RequestBody RequestPost requestPost){
        Post result = postUseCase.add(requestPost.getPost(), requestPost.getUserId());
        return new ResponseEntity<>(new ResponsePost(result), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<ResponsePost>> getAll(@RequestBody PostCriteria postCriteria){
        List<Post> all = postUseCase.findByCriteria(postCriteria);
        List<ResponsePost> result = all.stream().map(ResponsePost::new).toList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
