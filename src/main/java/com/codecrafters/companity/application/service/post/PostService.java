package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.application.out.persistence.PostRepository;
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
    private final PostFactory postFactory;
    @Override
    public Post add(PostForCreate postForCreate) {
        User user = getUser();
        return postRepository.add(postForCreate.toPost(user));
    }

    private User getUser(){
        //TODO need to implement about get user
        //maybe we should use userUseCase -> userUseCase.getUser();
        return User.builder().userId("shtjdrb").userName("노성규").nickName("안녕").build();
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
