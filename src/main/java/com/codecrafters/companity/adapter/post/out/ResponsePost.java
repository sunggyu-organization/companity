package com.codecrafters.companity.adapter.post.out;

import com.codecrafters.companity.adapter.user.ResponseUser;
import com.codecrafters.companity.domain.post.Post;

import java.time.LocalDateTime;

public class ResponsePost {
    private Long id;
    private String title;
    private int city;
    private int sportsTypes;
    private String content;
    private LocalDateTime date;
    private boolean recruit;
    private int likeCount;
    private ResponseUser owner;
    public ResponsePost(Post post){
    }
}
