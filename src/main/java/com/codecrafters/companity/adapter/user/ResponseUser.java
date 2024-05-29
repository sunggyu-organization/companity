package com.codecrafters.companity.adapter.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ResponseUser {
    private String userId;
    private String userName;
    private String nickName;
}
