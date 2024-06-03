package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.mock.repository.PostInMemoryImpl;
import com.codecrafters.companity.mock.repository.UserInMemoryImpl;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.config.mapper.CustomModelMapper;
import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codecrafters.companity.static_reference.PostStatic.*;
import static com.codecrafters.companity.static_reference.UserStatic.*;

class PostServiceTest {
    private PostService postService;
    private UserRepository userRepository;
    private PostRepository postRepository;

    private PostRepository getPostRepository(){
        return new PostInMemoryImpl();
    }

    private UserRepository getUserRepository(){
        return new UserInMemoryImpl();
    }

    @BeforeEach
    public void init(){
        userRepository = getUserRepository();
        postRepository = getPostRepository();
        CustomModelMapper mapper = new CustomModelMapper();
        postService = new PostService(postRepository);
    }

    @Test
    void add() {
        //TODO need to implement getUser method
    }

    private PostForCreate getDefaultPost(){
        return PostForCreate.builder()
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sport(SPORT_TYPE)
                .build();
    }

    private User addDefaultUserToRepository(){
        return userRepository.save(User.builder().userId(USER_ID).userName(USER_NAME).nickName(NICKNAME).build());
    }

    private Long addDefaultPostToRepository(User user){
        return postService.add(getDefaultPost()).getId();
    }
}