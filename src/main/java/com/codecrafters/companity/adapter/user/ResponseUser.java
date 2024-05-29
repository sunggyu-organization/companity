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
    private Long id;
    private String username;
}
