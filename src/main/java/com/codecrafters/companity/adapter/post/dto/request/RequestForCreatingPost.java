package com.codecrafters.companity.adapter.post.dto.request;

import com.codecrafters.companity.adapter.post.mapper.PostMapperForController;
import com.codecrafters.companity.application.in.post.dto.PostForCreate;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequestForCreatingPost {
    private String title;
    private City city;
    private Sport sport;
    private String content;

    public PostForCreate toPostCreateDto(){
        return PostMapperForController.POST_MAPPER_FOR_CONTROLLER.toPost(this);
    }
}
