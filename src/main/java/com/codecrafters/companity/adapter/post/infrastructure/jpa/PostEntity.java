package com.codecrafters.companity.adapter.post.infrastructure.jpa;

import com.codecrafters.companity.adapter.infrastructure.jpa.comment.CommentEntity;
import com.codecrafters.companity.adapter.infrastructure.jpa.common.BaseTimeEntity;
import com.codecrafters.companity.adapter.user.infrastructure.jpa.UserEntity;
import com.codecrafters.companity.domain.enums.City;
import com.codecrafters.companity.domain.enums.Sport;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.post.PostForUpdate;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;

    public void update(PostForUpdate postForUpdate){
        this.title = postForUpdate.getTitle();
        this.sport = postForUpdate.getSport();
        this.city = postForUpdate.getCity();
        this.content = postForUpdate.getContent();
    }

    public Post toDomain(){
        return Post.builder()
                .id(this.id)
                .title(this.title)
                .sport(this.sport)
                .city(this.city)
                .content(this.content)
                .recruit(this.recruit)
                .likeCount(this.likeCount)
                .owner(this.owner.toDomain())
                .comments(null)
                .createdAt(this.getCreatedAt())
                .modifiedAt(this.getModifiedAt())
                .build();
    }
}
