package com.codecrafters.companity.mock.repository;

import com.codecrafters.companity.adapter.post.infrastructure.jpa.PostEntity;
import com.codecrafters.companity.adapter.user.infrastructure.jpa.UserEntity;
import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.domain.post.Post;
import com.codecrafters.companity.domain.user.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


public class PostInMemoryImpl implements PostRepository {
    public final Map<Long, PostEntity> repository = new ConcurrentHashMap<>();
    private final AtomicLong keyCreator = new AtomicLong();
    @Override
    public Post add(Post post) {
        PostEntity postToSave = PostEntity.builder().id(keyCreator.getAndIncrement())
                .title(post.getTitle())
                .owner(toUserEntity(post.getOwner()))
                .recruit(post.getRecruit())
                .city(post.getCity())
                .content(post.getContent())
                .sport(post.getSport())
                .likeCount(post.getLikeCount())
                .build();
        repository.put(postToSave.getId(), postToSave);
        return toPost(postToSave);
    }

    @Override
    public Post getPost(Long id) {
        if(!repository.containsKey(id)) throw new IllegalArgumentException();
        PostEntity entity = repository.get(id);
        return toPost(entity);
    }

    @Override
    public Post update(Post post) {
        PostEntity entity = repository.get(post.getId());
        if(entity == null) throw new IllegalArgumentException("존재하지 않는 게시물입니다.");
        entity.update(post);
        repository.put(entity.getId(), entity);
        return toPost(entity);
    }

    @Override
    public List<Post> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private UserEntity toUserEntity(User user){
        return UserEntity.builder().userId(user.getUserId()).userName(user.getUserName()).nickName(user.getNickName()).build();
    }

    private Post toPost(PostEntity entity){
        return Post.builder()
                .id(entity.getId())
                .createdAt(null)
                .modifiedAt(null)
                .title(entity.getTitle())
                .owner(toUser(entity.getOwner()))
                .recruit(entity.isRecruit())
                .city(entity.getCity())
                .content(entity.getContent())
                .sport(entity.getSport())
                .likeCount(entity.getLikeCount())
                .build();
    }
    private User toUser(UserEntity user){
        return User.builder().userId(user.getUserId()).userName(user.getUserName()).nickName(user.getNickName()).build();
    }
}
