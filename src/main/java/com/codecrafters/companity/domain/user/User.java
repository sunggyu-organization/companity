package com.codecrafters.companity.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String nickName;
}
