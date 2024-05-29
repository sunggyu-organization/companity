package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.application.in.post.dto.PostCreateDto;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.codecrafters.companity.config.mapper.PostMapper.postMapper;


@RequiredArgsConstructor
@Slf4j
@Service
public class PostService implements PostUseCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostFactory postFactory;
    @Override
    public Post add(PostCreateDto dto, Long userId) {
        User user = userRepository.getUserById(userId);
        Post newPost = postMapper.getPostForCreating(dto, user);
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
    public Post findDetailById(Long id) {
        return postRepository.getById(id);
    }
}
