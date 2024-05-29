package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.usecase.PostUseCase;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.application.out.utility.DateTimeProvider;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class PostService implements PostUseCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostFactory postFactory;

    private final DateTimeProvider dateTimeProvider;

    @Override
    public Post add(Post post, String userId) {
        User user = userRepository.getUserById(userId);
        Post newPost = postFactory.create(post, user, dateTimeProvider.getNow());
        return postRepository.add(newPost);
    }

    @Override
    public Post update(Long postId, Post post) {
        Post oldPost = postRepository.getById(postId);
        return postRepository.save(postFactory.update(oldPost, post));
    }

    @Override
    public List<Post> findByCriteria(PostCriteria postCriteria) {
        //TODO need to make pagination
        return postRepository.findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(postCriteria);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.getById(id);
    }
}
