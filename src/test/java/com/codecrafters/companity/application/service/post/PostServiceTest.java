package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.adapter.post.infrastructure.inmemory.PostInMemoryImpl;
import com.codecrafters.companity.adapter.user.infrastructure.inmemory.UserInMemoryImpl;
import com.codecrafters.companity.application.out.persistance.post.PostRepository;
import com.codecrafters.companity.application.out.persistance.user.UserRepository;
import com.codecrafters.companity.domain.enumclass.City;
import com.codecrafters.companity.domain.enumclass.SportType;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import com.codecrafters.companity.mock.TestLocalDateTimeProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class PostServiceTest {
    private static final String DEFAULT_USER_NAME = "shtjdrb";
    private static final String DEFAULT_NICKNAME = "노성규";
    private static final LocalDateTime fixedLocalDateTime = LocalDateTime.now();

    private PostService postService;
    private UserRepository userRepository;
    private PostRepository postRepository;

    private PostRepository getPostRepository(){
        return new PostInMemoryImpl();
    }

    private UserRepository getUserRepository(){
        UserInMemoryImpl userRepository = new UserInMemoryImpl();
        User user = User.builder().username(DEFAULT_USER_NAME).nickName(DEFAULT_NICKNAME).build();
        userRepository.add(user);
        return userRepository;
    }

    private TestLocalDateTimeProvider getLocalDateTimeProvider(){
        return new TestLocalDateTimeProvider(fixedLocalDateTime);
    }
    @BeforeEach
    public void init(){
        userRepository = getUserRepository();
        postRepository = getPostRepository();
        postService = new PostService(postRepository, userRepository, getLocalDateTimeProvider());
    }

    @Test
    void add() {
        //given
        String title = "Test Title";
        City city = City.Seoul;
        String content = "Test Content";
        SportType sportType = SportType.Soccer;

        Post post = Post.builder()
                .title(title)
                .city(city)
                .content(content)
                .sportType(sportType)
                .build();
        User user = userRepository.getUserByUsername(DEFAULT_USER_NAME);

        //when
        Long savedUserId = postService.add(post, user.getId()).getId();

        //then
        Post savedPost = postRepository.getById(savedUserId);
        assertThat(savedPost.getCity()).isEqualTo(city);
        assertThat(savedPost.getComments()).isNull();
        assertThat(savedPost.getContent()).isEqualTo(content);
        assertThat(savedPost.getTitle()).isEqualTo(title);
        assertThat(savedPost.getLikeCount()).isEqualTo(0);
        assertThat(savedPost.getUser()).isEqualTo(user);
        assertThat(savedPost.getLocalDateTime()).isEqualTo(fixedLocalDateTime);
    }
}