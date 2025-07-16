package com.spring.basic.chap5_4.dto.response;


// 클라이언트에게 멤버 목록을 보내줄 때 사용할 응답 DTO

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.basic.chap3_2.entity.Member;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberListResponse {
    private String id; // 변수명은 클라이언트의 요청에 따라 유연하게 조절가능

    @JsonProperty("account")
    private String email; // account에 대응
    private String nick; // 가운데 글자를 마스킹 (첫글자랑 마지막글자 빼고)

    @JsonIgnore
    private String cardNo;

    @JsonFormat(pattern = "yyyy년 MM월 dd일") // 시간 패턴지정
    private LocalDate creationTime;


    // 엔터티를 전달받아서 dto로 변환하는 정적 팩토리 메서드
    public static MemberListResponse from(Member member){
        return MemberListResponse.builder()
                .id(member.getUid())
                .email(member.getAccount())
                .nick(maskingNickname(member.getNickname()))
                .creationTime(LocalDate.now())
                .build();
    }

    private static String maskingNickname(String originNick){
        String maskingNick = "" + originNick.charAt(0) + "*" + originNick.charAt(originNick.length() - 1);
        return maskingNick;
    }


}
