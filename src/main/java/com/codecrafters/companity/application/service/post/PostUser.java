package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostUserCase;
import com.codecrafters.companity.application.out.datetime.LocalDateTimeProvider;
import com.codecrafters.companity.application.out.persistance.post.PostRepository;
import com.codecrafters.companity.application.out.persistance.user.UserRepository;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;


@RequiredArgsConstructor
@Slf4j
public class PostUser implements PostUserCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final LocalDateTimeProvider dateTimeProvider;

    @Override
    public Post add(Post post, Long userId) {
        User user = userRepository.getUserById(userId);
        Post newPost = post.create(user, dateTimeProvider.getNow(), modelMapper);
        return postRepository.add(newPost);
    }

    @Override
    public Post update(Long postId, Post post) {
        Post oldPost = postRepository.getById(postId);
        return postRepository.save(oldPost.update(post, modelMapper));
    }
}
