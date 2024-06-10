package com.codecrafters.companity.application.service.user;

import com.codecrafters.companity.user.adapter.dto.request.UserCreateRequest;
import com.codecrafters.companity.user.application.UserService;
import com.codecrafters.companity.user.application.port.out.UserRepository;
import com.codecrafters.companity.user.domain.User;
import com.codecrafters.companity.exception.CustomException;
import com.codecrafters.companity.mock.repository.UserInMemoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codecrafters.companity.static_reference.UserStatic.*;

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
        Assertions.assertAll(() -> {
            Assertions.assertEquals(request.getUserId(), user.getUserId());
            Assertions.assertEquals(request.getUserName(), user.getUserName());
            Assertions.assertEquals(request.getNickName(), user.getNickName());
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
        Assertions.assertAll(() -> {
            Assertions.assertEquals(userId, newUser.getUserId());
            Assertions.assertEquals(USER_NAME, newUser.getUserName());
            Assertions.assertEquals(newNickName, newUser.getNickName());
        });
    }

    @Test
    public void userId에_해당하는_특정_User를_삭제할_수_있다() {
        //given
        String userId = USER_ID;
        UserCreateRequest request = new UserCreateRequest(userId, USER_NAME, NICKNAME);
        User user = userService.signUp(request);

        //when
        userService.delete(userId);

        //then
        Assertions.assertThrows(CustomException.class, () -> userRepository.getUserById(userId));
    }

}
