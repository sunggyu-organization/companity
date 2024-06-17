package com.codecrafters.companity.domain.Comment;

import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@Builder
public class AddingComment {
    private String content;

    public Comment toComment(Post post, User user){
        validate(post, user);
        return Comment.builder().post(post.clone()).owner(user.clone()).content(content).build();
    }

    private void validate(Post post, User user){
        if(!StringUtils.hasText(content)) throw new IllegalArgumentException("Content must not be null");
        if(user == null) throw new IllegalArgumentException("User must not be null");
        if(post == null) throw new IllegalArgumentException("Post must not be null");
    }
}
