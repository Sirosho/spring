package com.spring.basic.chap5_3.dto.request;

// 회원 가입 전용 객체

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberCreateDto {

    private String userAcc;
    private String pw;
    private String nick;
}
