package com.codecrafters.companity.application.service.user;

import com.codecrafters.companity.adapter.user.dto.request.UserCreateRequest;
import com.codecrafters.companity.application.out.persistence.UserRepository;
import com.codecrafters.companity.domain.user.User;
import com.codecrafters.companity.mock.repository.UserInMemoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codecrafters.companity.static_reference.UserStatic.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    public UserServiceTest() {
        userRepository = new UserInMemoryImpl();
        userService = new UserService(userRepository);
        userRepository.save(User.builder().userId(USER_ID).userName(USER_NAME).nickName(NICKNAME).build());
    }

    @Test
    public void UserCreateRequest객체로_User를_저장할_수_있다() {
        //given
        UserCreateRequest request = new UserCreateRequest(USER_ID, USER_NAME, NICKNAME);

        //when
        User user = userService.signUp(request);

        //then
        assertSoftly(softAssertions -> {
            assertThat(user.getUserId()).isEqualTo(request.getUserId());
            assertThat(user.getUserName()).isEqualTo(request.getUserName());
            assertThat(user.getNickName()).isEqualTo(request.getNickName());
        });
    }

    @Test
    public void updateNickName() {
        //given
        String userId = USER_ID;
        String newNickName = "NEW_NICK_NAME";

        //when
        User newUser = userService.updateNickName(userId, newNickName);

        //then
        assertSoftly(softAssertions -> {
            assertThat(newUser.getUserId()).isEqualTo(userId);
            assertThat(newUser.getUserName()).isEqualTo(USER_NAME);
            assertThat(newUser.getNickName()).isEqualTo(newNickName);
        });
    }

}
