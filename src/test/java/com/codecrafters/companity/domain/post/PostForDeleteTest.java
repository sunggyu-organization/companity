package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PostForDeleteTest {
    @Test
    void delete(){
        // given
        PostForDelete postForDelete = PostForDelete.builder()
                .owner(getDefaultUser())
                .postId(1L)
                .build();

        Post post = Post.builder()
                .owner(getDefaultUser())
                .build();

        // when
        // then
        assertDoesNotThrow(() -> postForDelete.validate(post));
    }

    @DisplayName("게시물 삭제 시 삭제하려는 사용자를 확인할 수 있어야 한다.")
    @Test
    void user_is_not_null(){
        // given
        PostForDelete postForDelete = PostForDelete.builder()
                .owner(null)
                .postId(1L)
                .build();

        Post post = Post.builder()
                .owner(getDefaultUser())
                .build();

        // when
        // then
        assertThatThrownBy(() -> postForDelete.validate(post)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("삭제하려는 사용자와 게시물 작성자는 동일해야 한다.")
    @Test
    void operator_is_the_same_as_the_writer(){
        // given
        PostForDelete postForDelete = PostForDelete.builder()
                .owner(getUserWithUserId("shtjdrb123"))
                .postId(1L)
                .build();

        Post post = Post.builder()
                .owner(getDefaultUser())
                .build();

        // when
        // then
        assertThatThrownBy(() -> postForDelete.validate(post)).isInstanceOf(IllegalArgumentException.class);
    }

    private User getDefaultUser(){
        return getUserWithUserId(USER_ID);
    }

    private User getUserWithUserId(String userId){
        return User.builder().userId(userId).userName(USER_NAME).nickName(NICKNAME).build();
    }
}