package com.codecrafters.companity.adapter.post.controller;

import com.codecrafters.companity.application.in.post.PostServiceCase;
import com.codecrafters.companity.domain.post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostServiceCase postServiceCase;
    @PostMapping("/add")
    public ResponseEntity<ResponsePost> add(@RequestBody RequestPost requestPost){
        Post result = postServiceCase.add(requestPost.getPost(), requestPost.getUserId());
        return new ResponseEntity<>(new ResponsePost(result), HttpStatus.OK);
    }
}
