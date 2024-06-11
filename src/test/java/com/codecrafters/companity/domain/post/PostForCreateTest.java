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

import static org.assertj.core.api.Assertions.*;
class PostForCreateTest {
    @DisplayName("post 생성")
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

    @DisplayName("사용자는 깊은 복사한다.")
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

    @DisplayName("제목, 도시, 스포츠는 필수 값이다.")
    @MethodSource("provideTitleCitySport")
    @ParameterizedTest(name="{index} => title={0}, city={1}, sport={2}, errorMessage={3}")
    void title_city_sport_are_require(String title, City city, Sport sport, String errorMessage) {
        // given
        PostForCreate postForCreate = PostForCreate.builder().title(title).sport(sport).city(city).content("content").build();
        User user = User.builder().userId("userId").userName("userName").nickName("nickName").build();

        // when
        // then
        assertThatThrownBy(() -> postForCreate.toPost(user)).isInstanceOf(IllegalArgumentException.class).hasMessage(errorMessage);
    }

    private static Stream<Arguments> provideTitleCitySport(){
        return Stream.of(
                Arguments.of("", City.Seoul, Sport.Baseball, "title is required."),
                Arguments.of(null, City.Seoul, Sport.Baseball, "title is required."),
                Arguments.of("Title", null, Sport.Baseball, "city is required."),
                Arguments.of("Title", City.Seoul, null, "sport is required.")
        );
    }
}