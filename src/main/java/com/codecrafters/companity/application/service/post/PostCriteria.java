package com.codecrafters.companity.application.service.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class PostCriteria {
    private String title;
    private City city;
    private Sport sport;
    private String content;
    private boolean recruit;
    private int likeCount;
    private OrderType orderType;
}
