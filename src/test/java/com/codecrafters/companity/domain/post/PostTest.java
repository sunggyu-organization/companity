package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enumclass.City;
import com.codecrafters.companity.domain.enumclass.SportType;
import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class PostTest {

    @Test
    void createNewPost() {
        Post requestPost = Post.builder()
                .title("Test Title")
                .city(City.Seoul)
                .content("Test Content")
                .sportType(SportType.Soccer)
                .build();
        User user = User.builder().userId("shtjdrb").nickName("노성규").build();
        LocalDate now = LocalDate.now();
        Post newPost = requestPost.createNewPost(user, now);

        assertThat(newPost.getId()).isNull();
        assertThat(newPost.getCity()).isEqualTo(requestPost.getCity());
        assertThat(newPost.getComments()).isNull();
        assertThat(newPost.getContent()).isEqualTo(requestPost.getContent());
        assertThat(newPost.getTitle()).isEqualTo(requestPost.getTitle());
        assertThat(newPost.getLikeCount()).isEqualTo(0);
        assertThat(newPost.getUser()).isEqualTo(user);
        assertThat(newPost.getLocalDate()).isEqualTo(now);
    }
}