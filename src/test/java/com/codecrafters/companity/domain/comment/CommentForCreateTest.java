package com.codecrafters.companity.domain.comment;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.assertj.core.api.Assertions.assertThat;

class CommentForCreateTest {
    @DisplayName("Comment 생성")
    @Test
    void add(){
        //given
        CommentForCreate target = CommentForCreate.builder().user(getDefaultUser()).post(getDefaultPost()).content("test").build();

        //when
        Comment comment = target.toComment();

        //then
        assertSoftly(softAssertions -> {
            assertThat(target.getContent()).isEqualTo(comment.getContent());
            assertThat(target.getUser()).isEqualTo(comment.getOwner());
            assertThat(target.getPost()).isEqualTo(comment.getPost());
        });

    }

    @DisplayName("사용자와 post는 깊은 복사한다.")
    @Test
    void Use_deep_copy_when_setting_owner_and_post() {
        //given
        CommentForCreate target = CommentForCreate.builder().user(getDefaultUser()).post(getDefaultPost()).content("test").build();

        //when
        Comment comment = target.toComment();

        // then
        assertSoftly(softAssertions -> {
            assertThat(target.getContent()).isEqualTo(comment.getContent());
            assertThat(target.getUser()).isEqualTo(comment.getOwner());
            assertThat(target.getPost()).isEqualTo(comment.getPost());
            assertThat(target.getUser()).isNotSameAs(comment.getOwner());
            assertThat(target.getPost()).isNotSameAs(comment.getPost());
        });
    }

    @DisplayName("내용, 사용자, post는 필수 값이다.")
    @MethodSource("provideContentAndUserAndPost")
    @ParameterizedTest
    void content_owner_post_are_require(String content, User user, Post post) {
        // given
        CommentForCreate target = CommentForCreate.builder().user(user).post(post).content(content).build();

        // when
        // then
        assertThatThrownBy(target::toComment).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideContentAndUserAndPost(){
        User user = User.builder().userId(USER_ID).userName(USER_NAME).nickName(NICKNAME).build();
        User owner = User.builder().userId("dhguswl").userName("오현지").nickName("오현지짱").build();
        Post post = Post.builder().owner(owner).title("title").sport(Sport.Baseball).city(City.Seoul).content("content").build();
        return Stream.of(
                Arguments.of("", user, post),
                Arguments.of("Content", null, post),
                Arguments.of("Content", user, null)
        );
    }

    private User getDefaultUser(){
        return User.builder().userId("shtjdrb").userName("노성규").nickName("노성규짱").build();
    }

    private Post getDefaultPost(){
        User owner = User.builder().userId("dhguswl").userName("오현지").nickName("오현지짱").build();
        return Post.builder().owner(owner).title("title").sport(Sport.Baseball).city(City.Seoul).content("content").build();
    }
}