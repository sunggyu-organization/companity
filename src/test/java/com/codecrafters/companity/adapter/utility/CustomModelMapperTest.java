package com.codecrafters.companity.adapter.utility;

import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostEntity;
import com.codecrafters.companity.config.mapper.CustomModelMapper;
import com.codecrafters.companity.domain.post.Post;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codecrafters.companity.static_reference.PostStatic.*;
import static com.codecrafters.companity.static_reference.PostStatic.SPORT_TYPE;
import static org.assertj.core.api.Assertions.assertThat;

class CustomModelMapperTest {

    private final CustomModelMapper modelMapper = new CustomModelMapper();

    @Test
    void copy() {
        //given
        Post post = getDefaultPost(1L);

        //when
        Post copy = modelMapper.copy(post);

        //then
        assertThat(copy.getCity()).isEqualTo(post.getCity());
        assertThat(copy.getContent()).isEqualTo(post.getContent());
        assertThat(copy.getTitle()).isEqualTo(post.getTitle());
        assertThat(copy.getLikeCount()).isEqualTo(post.getLikeCount());
        assertThat(copy.getRecruit()).isEqualTo(post.getRecruit());
        assertThat(copy.getId()).isEqualTo(post.getId());
    }

    @Test
    void overwrite() {
        //given
        Post oldOne = getDefaultPost(0L);
        Post newOne = Post.builder().title("overwirte test").build();

        //when
        Post overwrite = modelMapper.overwrite(newOne, oldOne);

        //then
        assertThat(overwrite.getCity()).isEqualTo(oldOne.getCity());
        assertThat(overwrite.getContent()).isEqualTo(oldOne.getContent());
        assertThat(overwrite.getLikeCount()).isEqualTo(oldOne.getLikeCount());
        assertThat(overwrite.getRecruit()).isEqualTo(oldOne.getRecruit());
        assertThat(overwrite.getId()).isEqualTo(oldOne.getId());

        assertThat(overwrite.getTitle()).isEqualTo("overwirte test");
        assertThat(oldOne.getTitle()).isEqualTo(TITLE);
    }

    @Test
    void convert() {
        //given
        Post post = getDefaultPost(2L);

        //when
        PostEntity entity = modelMapper.convert(post, PostEntity.class);

        //then
        assertThat(entity.getCity()).isEqualTo(post.getCity());
        assertThat(entity.getComments()).isNullOrEmpty();
        assertThat(entity.getContent()).isEqualTo(post.getContent());
        assertThat(entity.getLikeCount()).isEqualTo(post.getLikeCount());
        assertThat(entity.isRecruit()).isEqualTo(false);
        assertThat(entity.getId()).isEqualTo(post.getId());
        assertThat(post.getTitle()).isEqualTo(post.getTitle());
    }

    @Test
    void convertList() {
        //given
        List<Post> posts = new ArrayList<>();
        posts.add(getDefaultPost(0L));
        posts.add(getDefaultPost(1L));
        //when
        List<PostEntity> postEntities = modelMapper.convertList(posts, PostEntity.class);

        //then
        PostEntity entity = postEntities.get(0);
        Post post = posts.get(0);
        assertThat(entity.getCity()).isEqualTo(post.getCity());
        assertThat(entity.getComments()).isNullOrEmpty();
        assertThat(entity.getContent()).isEqualTo(post.getContent());
        assertThat(entity.getLikeCount()).isEqualTo(post.getLikeCount());
        assertThat(entity.isRecruit()).isEqualTo(false);
        assertThat(entity.getId()).isEqualTo(0L);
        assertThat(entity.getTitle()).isEqualTo(post.getTitle());

        entity = postEntities.get(1);
        post = posts.get(1);
        assertThat(entity.getCity()).isEqualTo(post.getCity());
        assertThat(entity.getComments()).isNullOrEmpty();
        assertThat(entity.getContent()).isEqualTo(post.getContent());
        assertThat(entity.getLikeCount()).isEqualTo(post.getLikeCount());
        assertThat(entity.isRecruit()).isEqualTo(false);
        assertThat(entity.getId()).isEqualTo(1L);
        assertThat(entity.getTitle()).isEqualTo(post.getTitle());
    }
    private Post getDefaultPost(Long index){
        return Post.builder()
                .id(index)
                .title(TITLE)
                .city(CITY)
                .content(CONTENT)
                .sport(SPORT_TYPE)
                .likeCount(20)
                .build();
    }
}