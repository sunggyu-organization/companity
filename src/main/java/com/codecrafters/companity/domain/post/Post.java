package com.codecrafters.companity.domain.post;

import com.codecrafters.companity.domain.BaseDomain;
import com.codecrafters.companity.domain.enumclass.City;
import com.codecrafters.companity.domain.enumclass.SportType;
import com.codecrafters.companity.domain.user.User;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseDomain {
    private User user;
    private Long id;
    private String title;
    private City city;
    private SportType sportType;
    private String content;
    private LocalDateTime localDateTime;
    private boolean recruit;
    private int likeCount;
    private List<Comment> comments;

    public Post create(User user, LocalDateTime localDateTime, ModelMapper modelMapper){
        Post result = copy(modelMapper, this);
        result.setUser(user);
        result.setLocalDateTime(localDateTime);
        return result;
    }
}
