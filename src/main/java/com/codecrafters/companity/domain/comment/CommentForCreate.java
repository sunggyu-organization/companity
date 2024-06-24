package com.codecrafters.companity.domain.comment;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@Builder
public class CommentForCreate {
    private String content;
    private Post post;
    private User user;

    public Comment toComment(){
        validate();
        return Comment.builder().post(post.clone()).owner(user.clone()).content(content).build();
    }

    private void validate(){
        if(!StringUtils.hasText(content)) throw new IllegalArgumentException("Content must not be null");
        if(user == null) throw new IllegalArgumentException("User must not be null");
        if(post == null) throw new IllegalArgumentException("Post must not be null");
    }
}
