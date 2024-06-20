package com.codecrafters.companity.adapter.post.dto.response;

import com.codecrafters.companity.adapter.user.ResponseUser;
import com.codecrafters.companity.domain.post.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import static com.codecrafters.companity.adapter.post.mapper.PostMapper.POST_MAPPER;

@Setter
@Getter
@ToString
public class ResponsePost {
    private Long id;
    private String title;
    private int cityNo;
    private int sportsNo;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private boolean recruit;
    private int likeCount;
    private ResponseUser owner;


    public static ResponsePost toDomain(Post post) {
        return POST_MAPPER.toResponsePost(post);
    }
}
