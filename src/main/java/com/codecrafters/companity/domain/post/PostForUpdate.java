package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@Builder
public class PostForUpdate {
    private Long id;
    private String title;
    private City city;
    private Sport sport;
    private String content;

    public void validate(){
        if (id == null) throw new IllegalArgumentException("id is required.");
        if (!StringUtils.hasText(title)) throw new IllegalArgumentException("title is required.");
        if (city == null) throw new IllegalArgumentException("city is required.");
        if (sport == null) throw new IllegalArgumentException("sport is required.");
    }
}
