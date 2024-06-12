package com.codecrafters.companity.adapter.post.dto.request;

import com.codecrafters.companity.adapter.post.mapper.PostMapper;
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
        return PostMapper.POST_MAPPER.toDomain(this);
    }
}
