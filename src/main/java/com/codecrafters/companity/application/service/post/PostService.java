package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.application.in.post.PostUseCase;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.domain.post.PostWithoutComment;
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
    public PostWithoutComment add(PostForCreate postForCreate) {
        User user = getUser();
        postForCreate.setOwner(user);
        return postRepository.add(postForCreate);
    }

    private User getUser(){
        //TODO need to implement about get user
        //maybe we should use userUseCase -> userUseCase.getUser();
        return User.builder().userId("shtjdrb").userName("노성규").nickName("안녕").build();
    }

    @Override
    public PostWithoutComment update(PostForUpdate postForUpdate) {
        return postRepository.update(postForUpdate);
    }

    @Override
    public List<PostWithoutComment> findByCriteria(PostCriteria postCriteria) {
        //TODO need to make pagination
        return postRepository.findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(postCriteria);
    }

    @Override
    public PostWithoutComment findDetailById(Long id) {
        return postRepository.getById(id);
    }
}
