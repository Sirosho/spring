package com.spring.basic.chap5_5.service;


import com.spring.basic.chap5_5.dto.request.FeedCreateRequest;
import com.spring.basic.chap5_5.dto.response.FeedDetailResponse;
import com.spring.basic.chap5_5.dto.response.FeedListResponse;
import com.spring.basic.chap5_5.entity.Feed;
import com.spring.basic.chap5_5.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// 데이터 변환 및 예외처리, 트랙잭션 담당
// Controller -> Service -> Repository
@Service
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    // 목록 요청에 대한 중간처리
    public List<FeedListResponse> listProcess(){
        // 저장소에게 접근해서 목록을 가져오라고 시킴(의존 객체에 위임)
        List<Feed> feeds = feedRepository.getFeeds();
        // 원본으로 주지말고 가릴건 가리고 예쁘게 만들건 예쁘게해서 컨드롤러에게 전달
        List<FeedListResponse> responses = feeds.stream()
                .map(FeedListResponse::from)
                .toList();
        return responses;
    }


    // 개별 요청에 대한 중간처리
    // 피드 Id, 생성시간 제외
    // 작성자명 (writer) 생성시간 제외
    // 작성자명 writer 피드내용은 feed_content 조회수(view) 응답

    // 생성 요청에 대한 중간처리
    public void createProcess(FeedCreateRequest dto) {
        feedRepository.save(FeedCreateRequest.toEntity(dto));
    }

    // 삭제 요청에 대한 중간처리
    // 삭제 요청에 대한 중간처리
    public void removeProcess(Long id) {
        boolean flag = feedRepository.deleteById(id);
        if (!flag) {
            throw new IllegalArgumentException("존재하지 않는 ID - " + id);
        }
    }

    public FeedDetailResponse findOneProcess(Long id){


    }


}










