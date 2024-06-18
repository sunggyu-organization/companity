package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.domain.post.PostForUpdate;
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
    @Override
    public Post add(PostForCreate postForCreate, User user) {
        return postRepository.add(postForCreate.toPost(user));
    }

    @Override
    public Post update(PostForUpdate postForUpdate) {
        Post post = postRepository.getById(postForUpdate.getId());
        return postRepository.update(postForUpdate.toPost(post));
    }

    @Override
    public void delete(Long id, User user) {
        Post target = postRepository.getById(id);
        if (user == null || !target.getOwner().getUserId().equals(user.getUserId())){
            throw new IllegalArgumentException("writer can only delete.");
        }
        postRepository.delete(id);
    }

    @Override
    public List<Post> findByCriteria(PostCriteria postCriteria) {
        //TODO need to make pagination
        return postRepository.findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(postCriteria);
    }
}
