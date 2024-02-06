package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostServiceCase;
import com.codecrafters.companity.application.out.persistance.post.PostRepository;
import com.codecrafters.companity.application.out.persistance.user.UserRepository;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@RequiredArgsConstructor
@Slf4j
public class PostService implements PostServiceCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Post add(Post post, Long userId) {
        User user = userRepository.getUserById(userId);
        Post newPost = post.createNewPost(user, LocalDate.now());
        return postRepository.add(newPost);
    }
}
