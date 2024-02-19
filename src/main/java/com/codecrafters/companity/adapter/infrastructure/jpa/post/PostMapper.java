package com.codecrafters.companity.adapter.infrastructure.jpa.post;

import com.codecrafters.companity.domain.post.Post;

final class PostMapper {
  static PostEntity toEntity(Post post) {
    //TODO need to describe and we can use objectMapper;
    return new PostEntity();
  }

  static Post toDomain(PostEntity entity) {
    //TODO need to describe and we can use objectMapper;
    return new Post();
  }
}
