package com.codecrafters.companity.comment.adapter.dto.request;

import com.codecrafters.companity.comment.domain.CommentForUpdate;
import com.codecrafters.companity.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdatingCommentDto {
    private Long id;
    private String content;

    public CommentForUpdate toCommentForUpdate(User user){
        return CommentForUpdate.builder().id(id).user(user).content(content).build();
    }
}
