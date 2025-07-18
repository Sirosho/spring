package com.spring.basic.chap5_5.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feed {

    private Long feedId;// 피드 식별번호
    private String content;//피드내용
    private String writer;//작성자명
    private LocalDateTime createdAt;//작성시간
    private int viewCount;// 조회수
}
