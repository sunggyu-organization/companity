package com.codecrafters.companity.comment.adapter.dto.request;

import com.codecrafters.companity.comment.domain.CommentForCreate;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddCommentDto {
    private Long postId;
    private String content;

    public CommentForCreate toCommentForCreate(Post post, User user){
        return CommentForCreate.builder().post(post).user(user).content(content).build();
    }
}
