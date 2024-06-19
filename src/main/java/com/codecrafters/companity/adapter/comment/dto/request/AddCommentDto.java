package com.codecrafters.companity.adapter.comment.dto.request;

import com.codecrafters.companity.domain.Comment.AddingComment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddCommentDto {
    private Long postId;
    private String content;

    public AddingComment toAddingComment(){
        return AddingComment.builder().content(content).build();
    }
}
