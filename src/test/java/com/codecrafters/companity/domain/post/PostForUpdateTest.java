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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class PostForUpdateTest {

    private User getUserWithUserId(String userId){
        return User.builder().userId(userId).userName("노성규").nickName("성규짱짱맨").build();
    }

    @DisplayName("post 수정")
    @Test
    void update() {
        User user = getUserWithUserId("shtjdrb");
        // given
        PostForUpdate newOne =
                PostForUpdate.builder()
                        .owner(user)
                        .id(1L)
                        .title("Updated Title")
                        .content("Updated Content")
                        .city(City.Busan)
                        .sport(Sport.Soccer)
                        .build();
        Post oldOne =
                Post.builder()
                        .owner(user)
                        .id(1L)
                        .title("Title")
                        .content("Content")
                        .city(City.Seoul)
                        .sport(Sport.Baseball)
                        .likeCount(20)
                        .recruit(true)
                        .build();

        // when
        Post updatedPost = newOne.toPost(oldOne);

        // then
        assertSoftly(softAssertions -> {
            assertThat(updatedPost.getOwner()).isEqualTo(newOne.getOwner());
            assertThat(updatedPost.getId()).isEqualTo(newOne.getId());
            assertThat(updatedPost.getTitle()).isEqualTo(newOne.getTitle());
            assertThat(updatedPost.getContent()).isEqualTo(newOne.getContent());
            assertThat(updatedPost.getCity()).isEqualTo(newOne.getCity());
            assertThat(updatedPost.getSport()).isEqualTo(newOne.getSport());
            assertThat(updatedPost.getLikeCount()).isEqualTo(oldOne.getLikeCount());
            assertThat(updatedPost.getRecruit()).isEqualTo(oldOne.getRecruit());
        });
    }

    @DisplayName("작성자는 null일 수 없다.")
    @Test
    void owner_is_not_null() {
        // given
        PostForUpdate postForUpdate =
                PostForUpdate.builder()
                        .id(1L)
                        .title("Title")
                        .sport(Sport.Baseball)
                        .city(City.Seoul)
                        .content("content").build();
        Post target =
                Post.builder()
                        .id(1L)
                        .title("Title")
                        .city(City.Seoul)
                        .sport(Sport.Baseball)
                        .content("content").build();
        // when
        // then
        assertThatThrownBy(() -> postForUpdate.toPost(target)).isInstanceOf(IllegalArgumentException.class).hasMessage("writer can only modify.");
    }

    @DisplayName("작성자만 수정할 수 있다.")
    @Test
    void owner_of_post_is_the_same_as_the_owner_of_post_for_update() {
        // given
        PostForUpdate postForUpdate =
                PostForUpdate.builder()
                        .owner(getUserWithUserId("shtjdrb"))
                        .id(1L)
                        .title("Title")
                        .sport(Sport.Baseball)
                        .city(City.Seoul)
                        .content("content").build();
        Post target =
                Post.builder()
                        .owner(getUserWithUserId("shtjdrb12"))
                        .id(1L)
                        .title("Updated Title")
                        .city(City.Seoul)
                        .sport(Sport.Baseball)
                        .content("content").build();
        // when
        // then
        assertThatThrownBy(() -> postForUpdate.toPost(target)).isInstanceOf(IllegalArgumentException.class).hasMessage("writer can only modify.");
    }
    @DisplayName("키, 제목, 도시, 스포츠는 필수 값이다.")
    @MethodSource("provideIdTitleCitySport")
    @ParameterizedTest(name="{index} => id={0}, title={1}, city={2}, sport={3}, errorMessage={4}")
    void id_title_city_sport_are_require(Long id, String title, City city, Sport sport, String errorMessage) {
        // given
        PostForUpdate postForUpdate =
                PostForUpdate.builder()
                        .owner(getUserWithUserId("shtjdrb"))
                        .id(id)
                        .title(title)
                        .sport(sport)
                        .city(city)
                        .content("content").build();
        Post target =
                Post.builder()
                        .owner(getUserWithUserId("shtjdrb"))
                        .id(1L)
                        .title("Title")
                        .city(City.Seoul)
                        .sport(Sport.Baseball)
                        .content("content").build();
        // when
        // then
        assertThatThrownBy(() -> postForUpdate.toPost(target)).isInstanceOf(IllegalArgumentException.class).hasMessage(errorMessage);
    }

    private static Stream<Arguments> provideIdTitleCitySport(){
        return Stream.of(
                Arguments.of(null, "Title", City.Seoul, Sport.Baseball, "id is required."),
                Arguments.of(1L, "", City.Seoul, Sport.Baseball, "title is required."),
                Arguments.of(1L, null, City.Seoul, Sport.Baseball, "title is required."),
                Arguments.of(1L, "Title", null, Sport.Baseball, "city is required."),
                Arguments.of(1L, "Title", City.Seoul, null, "sport is required.")
        );
    }
}