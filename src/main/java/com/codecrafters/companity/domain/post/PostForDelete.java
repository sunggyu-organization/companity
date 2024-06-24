package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostForDelete {
    private User owner;
    private Long postId;

    public void validate(Post target){
        if (owner == null || !target.getOwner().getUserId().equals(owner.getUserId())){
            throw new IllegalArgumentException("writer can only delete.");
        }
    }
}
