package com.spring.basic.chap3_2.controller;

import com.spring.basic.chap3_2.entity.Member;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v3-2/members")
public class MemberController3_2 {

    private Map<String,Member> memberStore= new HashMap<>();


    public MemberController3_2() {

        Member member1 = Member.builder() // 빌더를 쓰면 new를 안해도 된다
                .account("abc1234")
                .password("9999")
                .nickname("뽀롱이")
                .build();

        Member member2 = Member.builder()
                .account("def1234")
                .password("9129")
                .nickname("핑순이")
                .build();


        memberStore.put(member1.getUid(), member1);
        memberStore.put(member2.getUid(), member2);




    }
        // 전체 조회
        @GetMapping
        public List<Member> list () {
            return new ArrayList<>(memberStore.values());
        }

        // 회원등록
    @PostMapping
    public String join(@RequestBody Member member){
        member.setUid(UUID.randomUUID().toString());
        memberStore.put(member.getUid(),member);
        return "새로운 멤버가 생성됨! " + member.getNickname();
    }

}
