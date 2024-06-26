package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class PostForCreateTest {
    @DisplayName("post 생성")
    @Test
    void create_post_for_add() {
        // given
        User user = getDefaultUser();
        PostForCreate postForCreate = PostForCreate.builder().owner(user).title("title").sport(Sport.Baseball).city(City.Seoul).content("content").build();

        // when
        Post post = postForCreate.toPost();

        // then
        assertSoftly(softAssertions -> {
            assertThat(post.getOwner()).isEqualTo(user);
            assertThat(post.getCity()).isEqualTo(City.Seoul);
            assertThat(post.getSport()).isEqualTo(Sport.Baseball);
            assertThat(post.getContent()).isEqualTo("content");
            assertThat(post.getTitle()).isEqualTo("title");
        });
    }

    @DisplayName("사용자는 깊은 복사한다.")
    @Test
    void Use_deep_copy_when_setting_owner() {
        // given
        User user = getDefaultUser();
        PostForCreate postForCreate = PostForCreate.builder().owner(user).title("title").sport(Sport.Baseball).city(City.Seoul).content("content").build();

        // when
        Post post = postForCreate.toPost();

        // then
        assertSoftly(softAssertions -> {
            assertThat(post.getOwner()).isEqualTo(user);
            assertThat(post.getCity()).isEqualTo(City.Seoul);
            assertThat(post.getSport()).isEqualTo(Sport.Baseball);
            assertThat(post.getContent()).isEqualTo("content");
            assertThat(post.getTitle()).isEqualTo("title");
            assertThat(post.getOwner()).isNotSameAs(user);
        });
    }

    @DisplayName("작성자, 제목, 도시, 스포츠는 필수 값이다.")
    @MethodSource("provideTitleCitySport")
    @ParameterizedTest(name="{index} => title={1}, city={2}, sport={3}")
    void title_city_sport_are_require(User user, String title, City city, Sport sport) {
        // given
        PostForCreate postForCreate = PostForCreate.builder().owner(user).title(title).sport(sport).city(city).content("content").build();

        // when
        // then
        assertThatThrownBy(postForCreate::toPost).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideTitleCitySport(){
        User user = User.builder().userId(USER_ID).userName(USER_NAME).nickName(NICKNAME).build();
        return Stream.of(
                Arguments.of(user, "", City.Seoul, Sport.Baseball),
                Arguments.of(user, null, City.Seoul, Sport.Baseball),
                Arguments.of(user, "Title", null, Sport.Baseball),
                Arguments.of(user, "Title", City.Seoul, null),
                Arguments.of(null, "Title", City.Seoul, Sport.Baseball)
        );
    }
    private User getDefaultUser(){
        return User.builder().userId(USER_ID).userName(USER_NAME).nickName(NICKNAME).build();
    }
}