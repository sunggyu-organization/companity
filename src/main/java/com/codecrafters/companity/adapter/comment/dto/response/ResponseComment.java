package com.codecrafters.companity.adapter.comment.dto.response;

import com.codecrafters.companity.domain.comment.Comment;
import com.codecrafters.companity.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import static com.codecrafters.companity.adapter.comment.CommentMapper.COMMENT_MAPPER;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ResponseComment {
    public static ResponseComment toDto(Comment domain){
        return COMMENT_MAPPER.toDto(domain);
    }
    private Long id;
    private User owner;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
