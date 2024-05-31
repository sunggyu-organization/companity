package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostForUpdate {
    private Long id;
    private String title;
    private City city;
    private Sport sport;
    private String content;
}
