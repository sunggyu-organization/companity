package com.codecrafters.companity.adapter.post.dto.request;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPost {
    private String userId;
    private String title;
    private City city;
    private Sport sport;
    private String content;
}
