package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostServiceCase;
import com.codecrafters.companity.application.out.persistance.post.PostRepository;
import com.codecrafters.companity.domain.post.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class PostService implements PostServiceCase {
    private final PostRepository postRepository;

    @Override
    public Post add(Post post) {
        return postRepository.add(post);
    }
}
