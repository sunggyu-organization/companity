package com.codecrafters.companity.domain.user;

import com.codecrafters.companity.adapter.user.dto.request.UserCreateRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class UserTest {

    @Test
     void UserCreateRequest를_User_Domain으로_변경한다() {
         //given
         UserCreateRequest request = new UserCreateRequest(USER_ID, USER_NAME, NICKNAME);

         //when
         User user = User.from(request);

         //then
        assertSoftly(softAssertions -> {
            assertThat(user.getUserId()).isEqualTo(request.getUserId());
            assertThat(user.getUserName()).isEqualTo(request.getUserName());
            assertThat(user.getNickName()).isEqualTo(request.getNickName());
        });
    }

    @Test
    void User의_필수_데이터가_입력되지_않으면_에러를_리턴한다() {
        //given
        User userCase1 = User.builder().build();
        User userCase2 = User.builder().userId(USER_ID).build();
        User userCase3 = User.builder().userName(USER_NAME).build();

        //when

        //then
        assertSoftly(softAssertions -> {
            assertThatThrownBy(userCase1::validateCreateUser).isInstanceOf(IllegalArgumentException.class).hasMessage("userId is required.");
            assertThatThrownBy(userCase2::validateCreateUser).isInstanceOf(IllegalArgumentException.class).hasMessage("userName is required.");
            assertThatThrownBy(userCase3::validateCreateUser).isInstanceOf(IllegalArgumentException.class).hasMessage("userId is required.");
        });
    }

    @Test
    void updateNickName(){
        //given
        User user = User.builder()
                .userId(USER_ID)
                .userName(USER_NAME)
                .nickName(NICKNAME)
                .build();

        //when
        user.updateNickName("NEW_NICK_NAME");

        //then
        assertSoftly(softAssertions -> {
            assertThat(user.getUserId()).isEqualTo(USER_ID);
            assertThat(user.getUserName()).isEqualTo(USER_NAME);
            assertThat(user.getNickName()).isEqualTo("NEW_NICK_NAME");
        });
    }
}
