package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostServiceCase;
import com.codecrafters.companity.application.out.datetime.LocalDateTimeProvider;
import com.codecrafters.companity.application.out.persistance.post.PostRepository;
import com.codecrafters.companity.application.out.persistance.user.UserRepository;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Slf4j
public class PostService implements PostServiceCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private final LocalDateTimeProvider dateTimeProvider;

    @Override
    public Post add(Post post, Long userId) {
        User user = userRepository.getUserById(userId);
        Post newPost = post.createPost(user, dateTimeProvider.getNow());
        return postRepository.add(newPost);
    }
}
