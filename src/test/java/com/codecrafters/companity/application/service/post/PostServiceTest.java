package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.mock.repository.PostInMemoryImpl;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codecrafters.companity.static_reference.PostStatic.*;
import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.assertThat;

class PostServiceTest {
    private PostService postService;
    private PostRepository postRepository;

    private PostRepository getPostRepository(){
        return new PostInMemoryImpl();
    }

    @BeforeEach
    public void init(){
        postRepository = getPostRepository();
        postService = new PostService(postRepository);
    }

    @DisplayName("게시물 추가")
    @Test
    void add() {
        //given
        User user = getDefaultUser();
        PostForCreate postForCreate = getDefaultPost(user);

        // when
        Long savedId = postService.add(postForCreate).getId();
        Post post = postRepository.getById(savedId);

        // then
        assertThat(post.getOwner()).isEqualTo(user);
        assertThat(post.getCity()).isEqualTo(CITY);
        assertThat(post.getSport()).isEqualTo(SPORT_TYPE);
        assertThat(post.getContent()).isEqualTo(CONTENT);
        assertThat(post.getTitle()).isEqualTo(TITLE);
        assertThat(post.getRecruit()).isEqualTo(false);
        assertThat(post.getLikeCount()).isEqualTo(0);
    }

    private PostForCreate getDefaultPost(User user){
        return PostForCreate.builder()
                .owner(user)
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sport(SPORT_TYPE)
                .build();
    }

    private User getDefaultUser(){
        return User.builder().userId(USER_ID).userName(USER_NAME).nickName(NICKNAME).build();
    }
}