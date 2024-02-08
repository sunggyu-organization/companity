package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

import static com.codecrafters.companity.static_reference.PostStatic.*;
import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.*;

class PostTest {

    @Test
    void create() {
        //given
        Post requestPost = Post.builder()
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sportType(SPORT_TYPE)
                .build();
        User user = User.builder().username(USER_NAME).nickName(NICKNAME).build();
        LocalDateTime now = LocalDateTime.now();
        ModelMapper mapper = new ModelMapper();

        //when
        Post newPost = requestPost.create(user, now, mapper);

        //then
        //post
        assertThat(newPost.getId()).isNull();
        assertThat(newPost.getCity()).isEqualTo(CITY);
        assertThat(newPost.getComments()).isNull();
        assertThat(newPost.getContent()).isEqualTo(CONTENT);
        assertThat(newPost.getTitle()).isEqualTo(TITLE);
        assertThat(newPost.getLikeCount()).isEqualTo(0);
        assertThat(newPost.getLocalDateTime()).isEqualTo(now);

        //user
        User writer = newPost.getUser();
        assertThat(writer.getUsername()).isEqualTo(USER_NAME);
        assertThat(writer.getNickName()).isEqualTo(NICKNAME);
        assertThat(writer.getId()).isNull();

    }

    @Test
    void update(){
        //given
        LocalDateTime now = LocalDateTime.now();
        Post oldPost = Post.builder()
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sportType(SPORT_TYPE)
                .user(User.builder().username(USER_NAME).nickName(NICKNAME).build())
                .localDateTime(now)
                .build();
        Post newPost = Post.builder().title("update test").build();
        ModelMapper mapper = new ModelMapper();

        //when
        Post updatedPost = oldPost.update(newPost, mapper);

        //then
        //post
        assertThat(updatedPost.getId()).isNull();
        assertThat(updatedPost.getCity()).isEqualTo(CITY);
        assertThat(updatedPost.getComments()).isNull();
        assertThat(updatedPost.getContent()).isEqualTo(CONTENT);
        assertThat(updatedPost.getTitle()).isEqualTo("update test");
        assertThat(updatedPost.getLikeCount()).isEqualTo(0);
        assertThat(updatedPost.getLocalDateTime()).isEqualTo(now);

        //user
        User writer = updatedPost.getUser();
        assertThat(writer.getUsername()).isEqualTo(USER_NAME);
        assertThat(writer.getNickName()).isEqualTo(NICKNAME);
        assertThat(writer.getId()).isNull();
    }

}