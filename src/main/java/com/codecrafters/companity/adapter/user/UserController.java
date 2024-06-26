package com.codecrafters.companity.adapter.user;

import com.codecrafters.companity.adapter.user.dto.request.UserCreateRequest;
import com.codecrafters.companity.adapter.user.dto.request.UserUpdateRequest;
import com.codecrafters.companity.adapter.user.dto.resposne.UserCreateResponse;
import com.codecrafters.companity.application.in.usecase.UserUseCase;
import com.codecrafters.companity.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping
    public ResponseEntity<UserCreateResponse> signUp (@RequestBody UserCreateRequest request) {
        User user = userUseCase.signUp(request);
        UserCreateResponse response = UserCreateResponse.from(user);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<HttpStatus> delete (@PathVariable("userId") String userId) throws Exception {
        userUseCase.delete(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // FIXME: 인증 Token을 이용해 userId를 가져오는 방식으로 변경 필요 /users/{userId}/nick-name -> /users/nick-name
    @PatchMapping("/{userId}/nick-name")
    public ResponseEntity<HttpStatus> signUp (@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        User user = userUseCase.updateNickName(userId, request.getNickName());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
