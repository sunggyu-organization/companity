package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.domain.post.PostForDelete;
import com.codecrafters.companity.domain.post.PostForUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Slf4j
@Service
public class PostService implements PostUseCase {
    private final PostRepository postRepository;
    @Override
    public Post add(PostForCreate postForCreate) {
        return postRepository.add(postForCreate.toPost());
    }

    @Override
    public Post update(PostForUpdate postForUpdate) {
        Post post = postRepository.getById(postForUpdate.getId());
        return postRepository.update(postForUpdate.toPost(post));
    }

    @Override
    public void delete(PostForDelete postForDelete) {
        Post target = postRepository.getById(postForDelete.getPostId());
        postForDelete.validate(target);
        postRepository.delete(target.getId());
    }

    @Override
    public Post get(Long postId) {
        return postRepository.getById(postId);
    }
}
