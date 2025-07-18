package com.spring.basic.chap5_5.repository;

import com.spring.basic.chap5_5.entity.Feed;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 게시물 피드 데이터를 전담 관리하는 클래스
// 관심사 : 데이터를 다루는 것만 관심있음. 요청응답 -> 관심없음
@Repository
public class FeedRepository {

    private Map<Long, Feed> feedStore = new HashMap<>();
    private Long feedNextId = 1L;

    public FeedRepository() {
        Feed f1 = Feed.builder()
                .feedId(feedNextId++)
                .content("하하호호재밌다")
                .writer("호빵맨")
                .createdAt(LocalDateTime.of(2025,3,14,13,15,0))
                .viewCount(3)
                .build();
        Feed f2 = Feed.builder()
                .feedId(feedNextId++)
                .content("하하호호")
                .writer("폼폼푸린")
                .createdAt(LocalDateTime.of(2025,4,14,11,15,0))
                .viewCount(7)
                .build();

        feedStore.put(f1.getFeedId(), f1);
        feedStore.put(f2.getFeedId(), f2);


    }

    // 데이터 전체조회를 하는 로직

    public List<Feed> getFeeds(){
        return new ArrayList<>(feedStore.values());
    }

    // 데이터 저장 로직
    public void save(Feed feed){
        feed.setFeedId(feedNextId++);
        feed.setCreatedAt(LocalDateTime.now());

        feedStore.put(feed.getFeedId(),feed);

    }

    // 데이터 삭제 로직
    public void delete(Long id) {
        feedStore.remove(id);
    }

    public List<Feed> find(Long id) {

        List<Feed> collectedFeeds = feedStore.values().stream()
                .filter(feed -> feed.getFeedId().equals(id))
                .toList();


        return collectedFeeds;
    }
}
