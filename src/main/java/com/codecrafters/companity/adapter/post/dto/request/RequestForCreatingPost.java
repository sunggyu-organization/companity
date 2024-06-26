package com.codecrafters.companity.adapter.post.dto.request;

import com.codecrafters.companity.adapter.post.PostMapper;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.domain.user.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequestForCreatingPost {
    private String title;
    private City city;
    private Sport sport;
    private String content;

    public PostForCreate toPostForCreate(User user){
        return PostMapper.POST_MAPPER.toDomain(this, user);
    }
}
