package com.codecrafters.companity.user.adapter;

import com.codecrafters.companity.user.adapter.dto.request.UserCreateRequest;
import com.codecrafters.companity.user.adapter.dto.request.UserUpdateRequest;
import com.codecrafters.companity.user.adapter.dto.resposne.UserCreateResponse;
import com.codecrafters.companity.user.application.port.in.UserUseCase;
import com.codecrafters.companity.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
