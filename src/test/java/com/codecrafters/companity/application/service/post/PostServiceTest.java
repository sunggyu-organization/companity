package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.adapter.post.infrastructure.inmemory.PostInMemoryImpl;
import com.codecrafters.companity.adapter.user.infrastructure.inmemory.UserInMemoryImpl;
import com.codecrafters.companity.application.out.persistance.PostRepository;
import com.codecrafters.companity.application.out.persistance.UserRepository;
import com.codecrafters.companity.application.utility.CustomModelMapper;
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
        return new UserInMemoryImpl();
    }

    private TestLocalDateTimeProvider getLocalDateTimeProvider(){
        return new TestLocalDateTimeProvider(FIXED_LOCAL_DATE_TIME);
    }
    @BeforeEach
    public void init(){
        userRepository = getUserRepository();
        postRepository = getPostRepository();
        CustomModelMapper mapper = new CustomModelMapper(new ModelMapper());
        PostFactory postFactory = new PostFactory(mapper);
        postService = new PostService(postRepository, userRepository, postFactory, getLocalDateTimeProvider());
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
        User user = userRepository.add(User.builder().username(USER_NAME).nickName(NICKNAME).build());

        //when
        Long savedPostId = postService.add(post, user.getId()).getId();

        //then
        //post
        Post savedPost = postRepository.getById(savedPostId);
        assertThat(savedPost.getCity()).isEqualTo(CITY);
        assertThat(savedPost.getComments()).isNull();
        assertThat(savedPost.getContent()).isEqualTo(CONTENT);
        assertThat(savedPost.getTitle()).isEqualTo(TITLE);
        assertThat(savedPost.getLikeCount()).isEqualTo(0);
        assertThat(savedPost.getLocalDateTime()).isEqualTo(FIXED_LOCAL_DATE_TIME);

        //user
        User writer = savedPost.getUser();
        assertThat(writer.getId()).isEqualTo(user.getId());
        assertThat(writer.getUsername()).isEqualTo(USER_NAME);
        assertThat(writer.getNickName()).isEqualTo(NICKNAME);
    }

    @Test
    void update() {
        //given
        Post oldPost = Post.builder()
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sportType(SPORT_TYPE)
                .build();
        User user = userRepository.add(User.builder().username(USER_NAME).nickName(NICKNAME).build());
        Long savedPostId = postService.add(oldPost, user.getId()).getId();
        Post newPost = Post.builder()
                .title("Post Update Test")
                .city(CITY)
                .content(CONTENT)
                .sportType(SPORT_TYPE)
                .build();
        //when
        postService.update(savedPostId, newPost);

        //then
        //post
        Post savedPost = postRepository.getById(savedPostId);
        assertThat(savedPost.getCity()).isEqualTo(CITY);
        assertThat(savedPost.getComments()).isNull();
        assertThat(savedPost.getContent()).isEqualTo(CONTENT);
        assertThat(savedPost.getTitle()).isEqualTo("Post Update Test");
        assertThat(savedPost.getLikeCount()).isEqualTo(0);
        assertThat(savedPost.getLocalDateTime()).isEqualTo(FIXED_LOCAL_DATE_TIME);

        //user
        User writer = savedPost.getUser();
        assertThat(writer.getId()).isEqualTo(user.getId());
        assertThat(writer.getUsername()).isEqualTo(USER_NAME);
        assertThat(writer.getNickName()).isEqualTo(NICKNAME);
    }
}