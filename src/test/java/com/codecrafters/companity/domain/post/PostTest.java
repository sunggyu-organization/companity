package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.codecrafters.companity.static_reference.PostStatic.*;
import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.*;

class PostTest {

    @Test
    void createNewPost() {
        //given
        Post requestPost = Post.builder()
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sportType(SPORT_TYPE)
                .build();
        User user = User.builder().username(USER_NAME).nickName(NICKNAME).build();
        LocalDateTime now = LocalDateTime.now();

        //when
        Post newPost = requestPost.createNewPost(user, now);

        //then
        assertThat(newPost.getId()).isNull();
        assertThat(newPost.getCity()).isEqualTo(CITY);
        assertThat(newPost.getComments()).isNull();
        assertThat(newPost.getContent()).isEqualTo(CONTENT);
        assertThat(newPost.getTitle()).isEqualTo(TITLE);
        assertThat(newPost.getLikeCount()).isEqualTo(0);
        assertThat(newPost.getUser()).isEqualTo(user);
        assertThat(newPost.getLocalDateTime()).isEqualTo(now);
    }
}