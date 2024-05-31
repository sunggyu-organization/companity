package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
class PostForCreateTest {
    @DisplayName("Post 작성자 설정")
    @Test
    void Set_post_owner() {
        // given
        PostForCreate postForCreate = PostForCreate.builder().title("title").sport(Sport.Baseball).city(City.Seoul).content("content").build();
        User user = User.builder().userId("userId").userName("userName").nickName("nickName").build();

        // when
        postForCreate.setOwner(user);

        // then
        assertThat(postForCreate.getOwner()).isEqualTo(user);
        assertThat(postForCreate.getCity()).isEqualTo(City.Seoul);
        assertThat(postForCreate.getSport()).isEqualTo(Sport.Baseball);
        assertThat(postForCreate.getContent()).isEqualTo("content");
        assertThat(postForCreate.getTitle()).isEqualTo("title");
    }

    @DisplayName("Post 작성자 설정 시 깊은 복사를 사용한다")
    @Test
    void Use_deep_copy_when_setting_owner() {
        // given
        PostForCreate postForCreate = PostForCreate.builder().title("title").sport(Sport.Baseball).city(City.Seoul).content("content").build();
        User user = User.builder().userId("userId").userName("userName").nickName("nickName").build();

        // when
        postForCreate.setOwner(user);

        // then
        assertThat(postForCreate.getOwner()).isEqualTo(user);
        assertThat(postForCreate.getCity()).isEqualTo(City.Seoul);
        assertThat(postForCreate.getSport()).isEqualTo(Sport.Baseball);
        assertThat(postForCreate.getContent()).isEqualTo("content");
        assertThat(postForCreate.getTitle()).isEqualTo("title");
        assertThat(postForCreate.getOwner()).isNotSameAs(user);
    }
}