package com.codecrafters.companity.domain.user;

import com.codecrafters.companity.adapter.user.dto.request.UserCreateRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codecrafters.companity.static_reference.UserStatic.*;

public class UserTest {

    @Test
     void UserCreateRequest를_User_Domain으로_변경한다() {
         //given
         UserCreateRequest request = new UserCreateRequest(USER_ID, USER_NAME, NICKNAME);

         //when
         User user = User.from(request);

         //then
         Assertions.assertAll(() -> {
             Assertions.assertEquals(request.getUserId(), user.getUserId());
             Assertions.assertEquals(request.getUserName(), user.getUserName());
             Assertions.assertEquals(request.getNickName(), user.getNickName());
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> userCase1.validateCreateUser());
        Assertions.assertThrows(IllegalArgumentException.class, () -> userCase2.validateCreateUser());
        Assertions.assertThrows(IllegalArgumentException.class, () -> userCase3.validateCreateUser());
    }
}
