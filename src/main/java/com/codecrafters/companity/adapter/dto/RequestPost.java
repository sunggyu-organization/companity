package com.codecrafters.companity.adapter.dto;

import com.codecrafters.companity.domain.post.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPost {
    private Long userId;
    public Post getPost(){
        //TODO need to describe
        return new Post();
    }
}
