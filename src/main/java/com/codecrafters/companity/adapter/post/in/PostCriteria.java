package com.codecrafters.companity.adapter.post.in;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostCriteria {
    private String title;
    private City city;
    private Sport sport;
    private String content;
    private boolean recruit;
    private int likeCount;
    private OrderType orderType;
}
