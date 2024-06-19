package com.codecrafters.companity.adapter.user.dto.response;

import com.codecrafters.companity.adapter.user.dto.resposne.UserCreateResponse;
import com.codecrafters.companity.domain.user.User;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codecrafters.companity.static_reference.PostStatic.CITY;
import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class UserCreateResponseTest {

    @Test
    public void User객체를_UserCreateResponse_응답객체로_생성할_수_있다() {
        //given
        User user = User.builder()
                .userId(USER_ID)
                .userName(USER_NAME)
                .nickName(NICKNAME)
                .build();

        //when
        UserCreateResponse resposne = UserCreateResponse.from(user);

        //then
        assertSoftly(softAssertions -> {
            assertThat(resposne.getUserId()).isEqualTo(user.getUserId());
            assertThat(resposne.getUserName()).isEqualTo(user.getUserName());
            assertThat(resposne.getNickName()).isEqualTo(user.getNickName());
        });
    }
}
