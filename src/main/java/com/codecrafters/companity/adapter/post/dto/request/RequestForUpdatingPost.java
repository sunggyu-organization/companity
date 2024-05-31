package com.codecrafters.companity.adapter.post.dto.request;

import com.codecrafters.companity.adapter.post.mapper.PostMapperForController;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.PostForUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestForUpdatingPost {
    private Long id;
    private String title;
    private City city;
    private Sport sport;
    private String content;

    public PostForUpdate toPostUpdateDto(){
        return PostMapperForController.POST_MAPPER_FOR_CONTROLLER.toPostForUpdate(this);
    }
}
