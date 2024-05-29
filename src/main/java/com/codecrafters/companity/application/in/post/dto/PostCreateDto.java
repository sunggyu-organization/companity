package com.codecrafters.companity.application.in.post.dto;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PostCreateDto {
    private String title;
    private City city;
    private Sport sport;
    private String content;
}
