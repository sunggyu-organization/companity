package com.codecrafters.companity.post.application.port.out.persistence;

import com.codecrafters.companity.post.domain.enums.City;
import com.codecrafters.companity.post.domain.enums.Sport;
import com.codecrafters.companity.post.domain.enums.OrderType;
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
