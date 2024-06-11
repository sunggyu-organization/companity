package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.post.application.PostFactory;
import com.codecrafters.companity.config.mapper.CustomModelMapper;
import com.codecrafters.companity.post.domain.Post;
import com.codecrafters.companity.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.codecrafters.companity.static_reference.PostStatic.*;
import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.assertThat;

class PostFactoryTest {
    private static final LocalDateTime FIXED_LOCAL_DATE_TIME = LocalDateTime.now();
    private PostFactory postFactory;
    @BeforeEach
    public void init(){
        CustomModelMapper mapper = new CustomModelMapper();
        postFactory = new PostFactory(mapper);
    }

    @Test
    void create() {
        //given
        Post requestPost = getDefaultPost();
        User user = getDefaultUser();

        //when
        Post newPost = postFactory.create(requestPost, user, FIXED_LOCAL_DATE_TIME);

        //then
        //post
        assertThat(newPost.getId()).isNull();
        assertThat(newPost.getCity()).isEqualTo(CITY);
        assertThat(newPost.getComments()).isNull();
        assertThat(newPost.getContent()).isEqualTo(CONTENT);
        assertThat(newPost.getTitle()).isEqualTo(TITLE);
        assertThat(newPost.getLikeCount()).isEqualTo(0);
        assertThat(newPost.getCreatedAt()).isEqualTo(FIXED_LOCAL_DATE_TIME);

        //user
        User writer = newPost.getOwner();
        assertThat(writer.equals(user)).isTrue();
    }

    @Test
    void update() {
        //given
        User user = getDefaultUser();
        Post oldPost = postFactory.create(getDefaultPost(), user, FIXED_LOCAL_DATE_TIME);
        Post newPost = Post.builder().title("update test").build();

        //when
        Post updatedPost = postFactory.update(oldPost, newPost);

        //then
        //post
        assertThat(updatedPost.getId()).isNull();
        assertThat(updatedPost.getCity()).isEqualTo(CITY);
        assertThat(updatedPost.getComments()).isNull();
        assertThat(updatedPost.getContent()).isEqualTo(CONTENT);
        assertThat(updatedPost.getTitle()).isEqualTo("update test");
        assertThat(updatedPost.getLikeCount()).isEqualTo(0);
        assertThat(updatedPost.getCreatedAt()).isEqualTo(FIXED_LOCAL_DATE_TIME);

        //user
        User writer = updatedPost.getOwner();
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
    private User getDefaultUser(){
        return User.builder().userId(USER_ID).userName(USER_NAME).nickName(NICKNAME).build();
    }
}