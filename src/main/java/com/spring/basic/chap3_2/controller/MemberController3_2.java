package com.spring.basic.chap3_2.controller;

import com.spring.basic.chap3_2.entity.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v3-2/members")
public class MemberController3_2 {

    private Map<String, Member> memberStore;


    public MemberController3_2() {

        Member member1 = Member.builder() // 빌더를 쓰면 new를 안해도 된다
                .account("abc1234")
                .password("9999")
                .nickName("뽀롱이")
                .build();

        Member member2 = Member.builder() // 빌더를 쓰면 new를 안해도 된다
                .account("def1234")
                .password("9129")
                .nickName("핑순이")
                .build();


        memberStore.put(member1.getUid(), member1);
        memberStore.put(member2.getUid(), member2);

        System.out.println("member1 = " + member1);


    }
}
