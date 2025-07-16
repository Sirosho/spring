package com.spring.basic.chap5_4.dto.response;


// 클라이언트에게 멤버 목록을 보내줄 때 사용할 응답 DTO

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberListResponse {
    private String id; // 변수명은 클라이언트의 요청에 따라 유연하게 조절가능
    private String email; // account에 대응
    private String nick; // 가운데 글자를 마스킹 (첫글자랑 마지막글자 빼고)
}
