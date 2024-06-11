package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PostForUpdateTest {
    @DisplayName("키, 제목, 도시, 스포츠는 필수 값이다.")
    @MethodSource("provideIdTitleCitySport")
    @ParameterizedTest(name="{index} => id={0}, title={1}, city={2}, sport={3}, errorMessage={4}")
    void title_city_sport_are_require(Long id, String title, City city, Sport sport, String errorMessage) {
        // given
        PostForUpdate postForUpdate = PostForUpdate.builder().id(id).title(title).sport(sport).city(city).content("content").build();

        // when
        // then
        assertThatThrownBy(postForUpdate::validate).isInstanceOf(IllegalArgumentException.class).hasMessage(errorMessage);
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