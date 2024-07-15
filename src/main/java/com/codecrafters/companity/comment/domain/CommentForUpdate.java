package com.codecrafters.companity.comment.domain;

import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@Builder
public class CommentForUpdate {
    private Long id;
    private String content;
    private User user;

    public Comment update(Comment original){
        validate(original);
        return Comment.builder()
                .id(id)
                .post(original.getPost().clone())
                .owner(user.clone())
                .content(content)
                .createdAt(original.getCreatedAt())
                .modifiedAt(original.getModifiedAt())
                .build();
    }

    private void validate(Comment comment){
        if(!StringUtils.hasText(content)) throw new IllegalArgumentException("Content must not be null");
        if(id == null) throw new IllegalArgumentException("Id must not be null");
        if(user == null) throw new IllegalArgumentException("User must not be null");
        if(!user.getUserId().equals(comment.getOwner().getUserId())) throw new IllegalArgumentException("User must be the same as the writer of the comment");
    }
}
