package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class PostForCreateTest {
    @DisplayName("등록용 post 생성")
    @Test
    void create_post_for_add() {
        // given
        PostForCreate postForCreate = PostForCreate.builder().title("title").sport(Sport.Baseball).city(City.Seoul).content("content").build();
        User user = User.builder().userId("userId").userName("userName").nickName("nickName").build();

        // when
        Post post = postForCreate.toPost(user);

        // then
        assertThat(post.getOwner()).isEqualTo(user);
        assertThat(post.getCity()).isEqualTo(City.Seoul);
        assertThat(post.getSport()).isEqualTo(Sport.Baseball);
        assertThat(post.getContent()).isEqualTo("content");
        assertThat(post.getTitle()).isEqualTo("title");
    }

    @DisplayName("Post 작성자 설정 시 깊은 복사를 사용한다")
    @Test
    void Use_deep_copy_when_setting_owner() {
        // given
        PostForCreate postForCreate = PostForCreate.builder().title("title").sport(Sport.Baseball).city(City.Seoul).content("content").build();
        User user = User.builder().userId("userId").userName("userName").nickName("nickName").build();

        // when
        Post post = postForCreate.toPost(user);

        // then
        assertThat(post.getOwner()).isEqualTo(user);
        assertThat(post.getCity()).isEqualTo(City.Seoul);
        assertThat(post.getSport()).isEqualTo(Sport.Baseball);
        assertThat(post.getContent()).isEqualTo("content");
        assertThat(post.getTitle()).isEqualTo("title");
        assertThat(post.getOwner()).isNotSameAs(user);
    }
}