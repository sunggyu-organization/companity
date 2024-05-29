package com.codecrafters.companity.adapter.post;

import com.codecrafters.companity.adapter.post.in.RequestForCreatingPost;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.adapter.post.out.ResponsePost;
import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.domain.post.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.codecrafters.companity.config.mapper.PostMapper.postMapper;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostUseCase postUseCase;
    @PostMapping
    public ResponseEntity<ResponsePost> add(@RequestBody RequestForCreatingPost requestPost){
        Post result = postUseCase.add(postMapper.toPost(requestPost), requestPost.getUserId());
        ResponsePost responsePost = postMapper.toResponsePost(result);
        return new ResponseEntity<>(responsePost, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ResponsePost>> getAll(@RequestBody PostCriteria criteria){
        //TODO need to implement
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePost> getDetail(@PathVariable("id") Long id){
        ResponsePost result = postMapper.toResponsePost(postUseCase.findDetailById(id));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
