package com.codecrafters.companity.application.out.persistence;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.OrderType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder(setterPrefix = "with") // JsonDeserialize uses builder method with
@JsonDeserialize(builder = PostCriteria.PostCriteriaBuilder.class)
public class PostCriteria {
    private String title;
    private City city;
    private Sport sport;
    private String content;
    private Boolean recruit;
    private OrderType orderType;
}
