package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.adapter.post.infrastructure.inmemory.PostInMemoryImpl;
import com.codecrafters.companity.adapter.user.infrastructure.inmemory.UserInMemoryImpl;
import com.codecrafters.companity.application.out.persistance.post.PostRepository;
import com.codecrafters.companity.application.out.persistance.user.UserRepository;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import com.codecrafters.companity.mock.TestLocalDateTimeProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

import static com.codecrafters.companity.static_reference.PostStatic.*;
import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.*;

class PostServiceTest {
    private static final LocalDateTime FIXED_LOCAL_DATE_TIME = LocalDateTime.now();

    private PostService postService;
    private UserRepository userRepository;
    private PostRepository postRepository;

    private PostRepository getPostRepository(){
        return new PostInMemoryImpl();
    }

    private UserRepository getUserRepository(){
        UserInMemoryImpl userRepository = new UserInMemoryImpl();
        User user = User.builder().username(USER_NAME).nickName(NICKNAME).build();
        userRepository.add(user);
        return userRepository;
    }

    private TestLocalDateTimeProvider getLocalDateTimeProvider(){
        return new TestLocalDateTimeProvider(FIXED_LOCAL_DATE_TIME);
    }
    @BeforeEach
    public void init(){
        userRepository = getUserRepository();
        postRepository = getPostRepository();
        ModelMapper mapper = new ModelMapper();
        postService = new PostService(postRepository, userRepository, mapper, getLocalDateTimeProvider());
    }

    @Test
    void add() {
        //given
        Post post = Post.builder()
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sportType(SPORT_TYPE)
                .build();
        User user = userRepository.getUserByUsername(USER_NAME);

        //when
        Long savedUserId = postService.add(post, user.getId()).getId();

        //then
        //post
        Post savedPost = postRepository.getById(savedUserId);
        assertThat(savedPost.getCity()).isEqualTo(CITY);
        assertThat(savedPost.getComments()).isNull();
        assertThat(savedPost.getContent()).isEqualTo(CONTENT);
        assertThat(savedPost.getTitle()).isEqualTo(TITLE);
        assertThat(savedPost.getLikeCount()).isEqualTo(0);
        assertThat(savedPost.getLocalDateTime()).isEqualTo(FIXED_LOCAL_DATE_TIME);

        //user
        User writer = savedPost.getUser();
        assertThat(writer.getId()).isEqualTo(savedUserId);
        assertThat(writer.getUsername()).isEqualTo(USER_NAME);
        assertThat(writer.getNickName()).isEqualTo(NICKNAME);
    }
}