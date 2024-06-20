package com.codecrafters.companity.adapter.post.infrastructure.jpa;

import com.codecrafters.companity.adapter.user.infrastructure.jpa.UserEntity;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostEntityTest {
    @DisplayName("post 업데이트")
    @Test
    void update_post() {
        // given
        UserEntity owner = UserEntity.builder().userId("userId").userName("userName").nickName("nickName").build();
        PostEntity post = PostEntity.builder().id(1L).title("title").sport(Sport.Baseball).owner(owner).city(City.Seoul).content("content").recruit(true).likeCount(20).build();
        Post postForUpdate = Post.builder().title("update title").sport(Sport.Soccer).city(City.Busan).content("update content").build();

        // when
        post.update(postForUpdate);

        // then
        assertThat(post.getOwner()).isEqualTo(owner);
        assertThat(post.getCity()).isEqualTo(City.Busan);
        assertThat(post.getSport()).isEqualTo(Sport.Soccer);
        assertThat(post.getContent()).isEqualTo("update content");
        assertThat(post.getTitle()).isEqualTo("update title");
    }

}