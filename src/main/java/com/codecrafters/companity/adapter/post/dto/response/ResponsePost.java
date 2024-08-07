package com.codecrafters.companity.adapter.post.dto.response;

import com.codecrafters.companity.adapter.post.PostMapper;
import com.codecrafters.companity.domain.post.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
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
    private String ownerName;

    public static ResponsePost toDomain(Post post) {
        return PostMapper.POST_MAPPER.toDto(post);
    }
}
