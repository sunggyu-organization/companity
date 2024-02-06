package com.codecrafters.companity.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private Long id;
    private String userId;
    private String nickName;

    @Override
    public boolean equals(Object obj) {
        User other = (User)obj;
        if(!other.getUserId().equals(this.userId)) return false;
        return other.getNickName().equals(this.nickName);
    }
}
