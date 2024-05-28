package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.mock.repository.PostInMemoryImpl;
import com.codecrafters.companity.mock.repository.UserInMemoryImpl;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.config.mapper.CustomModelMapper;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import com.codecrafters.companity.mock.TestDateTimeProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    private TestDateTimeProvider getLocalDateTimeProvider(){
        return new TestDateTimeProvider(FIXED_LOCAL_DATE_TIME);
    }
    @BeforeEach
    public void init(){
        userRepository = getUserRepository();
        postRepository = getPostRepository();
        CustomModelMapper mapper = new CustomModelMapper();
        PostFactory postFactory = new PostFactory(mapper);
        postService = new PostService(postRepository, userRepository, postFactory, getLocalDateTimeProvider());
    }

    @Test
    void add() {
        //given
        Post post = getDefaultPost();
        User user = addDefaultUserToRepository();

        //when
        Long savedPostId = postService.add(post, user.getId()).getId();

        //then
        //post
        Post savedPost = postRepository.getById(savedPostId);
        assertThat(savedPost.getCity()).isEqualTo(CITY);
        assertThat(savedPost.getContent()).isEqualTo(CONTENT);
        assertThat(savedPost.getTitle()).isEqualTo(TITLE);
        assertThat(savedPost.getLikeCount()).isEqualTo(0);
        assertThat(savedPost.getCreatedAt()).isEqualTo(FIXED_LOCAL_DATE_TIME);

        //user
        User writer = savedPost.getOwner();
        assertThat(writer.equals(user)).isTrue();
    }

    @Test
    void update() {
        //given
        User user = addDefaultUserToRepository();
        Long savedPostId = addDefaultPostToRepository(user);
        Post newPost = Post.builder().title("Post Update Test").build();
        //when
        postService.update(savedPostId, newPost);

        //then
        //post
        Post savedPost = postRepository.getById(savedPostId);
        assertThat(savedPost.getCity()).isEqualTo(CITY);
        assertThat(savedPost.getContent()).isEqualTo(CONTENT);
        assertThat(savedPost.getTitle()).isEqualTo("Post Update Test");
        assertThat(savedPost.getLikeCount()).isEqualTo(0);
        assertThat(savedPost.getCreatedAt()).isEqualTo(FIXED_LOCAL_DATE_TIME);

        //user
        User writer = savedPost.getOwner();
        assertThat(writer.equals(user)).isTrue();
    }

    private Post getDefaultPost(){
        return Post.builder()
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sport(SPORT_TYPE)
                .build();
    }

    private User addDefaultUserToRepository(){
        return userRepository.add(User.builder().username(USER_NAME).nickName(NICKNAME).build());
    }

    private Long addDefaultPostToRepository(User user){
        return postService.add(getDefaultPost(), user.getId()).getId();
    }
}