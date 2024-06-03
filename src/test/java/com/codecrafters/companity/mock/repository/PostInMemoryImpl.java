package com.codecrafters.companity.mock.repository;

import com.codecrafters.companity.application.out.persistence.PostRepository;
import com.codecrafters.companity.application.out.persistence.PostCriteria;
import com.codecrafters.companity.domain.post.PostForCreate;
import com.codecrafters.companity.domain.post.PostWithoutComment;
import com.codecrafters.companity.domain.post.PostForUpdate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostInMemoryImpl implements PostRepository {
    public final Map<Long, PostWithoutComment> repository = new ConcurrentHashMap<>();
    private final AtomicLong keyCreator = new AtomicLong();
    @Override
    public PostWithoutComment add(PostForCreate post) {
        PostWithoutComment build = PostWithoutComment.builder().id(keyCreator.getAndIncrement())
                .createdAt(null)
                .title(post.getTitle())
                .owner(post.getOwner())
                .recruit(false)
                .city(post.getCity())
                .content(post.getContent())
                .sport(post.getSport())
                .likeCount(0).build();
        repository.put(build.getId(), build);
        return build;
    }

    @Override
    public PostWithoutComment getById(Long id) {
        if(!repository.containsKey(id)) throw new IllegalArgumentException();
        return repository.get(id);
    }

    @Override
    public PostWithoutComment update(PostForUpdate postForUpdate) {
        PostWithoutComment post = repository.get(postForUpdate.getId());
        PostWithoutComment build = PostWithoutComment.builder().id(post.getId())
                .createdAt(post.getCreatedAt())
                .title(postForUpdate.getTitle())
                .owner(post.getOwner())
                .recruit(post.getRecruit())
                .city(postForUpdate.getCity())
                .content(postForUpdate.getContent())
                .sport(postForUpdate.getSport())
                .likeCount(post.getLikeCount()).build();
        repository.put(post.getId(), build);
        return build;
    }

    @Override
    public List<PostWithoutComment> findBySportAndCityAndRecruitOrderByRecentDateOrFavorite(PostCriteria postCriteria) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
