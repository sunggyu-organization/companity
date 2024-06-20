package com.codecrafters.companity.adapter.post.infrastructure.jpa;

import com.codecrafters.companity.adapter.common.infrastructure.jpa.BaseTimeEntity;
import com.codecrafters.companity.adapter.user.infrastructure.jpa.UserEntity;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Post")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Sport sport;

    @Enumerated(EnumType.STRING)
    private City city;
    private String content;
    private boolean recruit;
    private int likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity owner;

    public void update(Post post){
        this.title = post.getTitle();
        this.sport = post.getSport();
        this.city = post.getCity();
        this.content = post.getContent();
    }
}
