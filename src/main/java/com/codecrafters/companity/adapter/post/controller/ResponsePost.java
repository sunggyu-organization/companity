package com.codecrafters.companity.adapter.post.controller;

import com.codecrafters.companity.adapter.user.controller.ResponseUser;
import com.codecrafters.companity.domain.post.Comment;
import com.codecrafters.companity.domain.post.Post;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<Comment> comments;
    public ResponsePost(Post post){
    }
}
