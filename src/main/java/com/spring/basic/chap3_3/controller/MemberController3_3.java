package com.spring.basic.chap3_3.controller;


import com.spring.basic.chap3_2.entity.Member;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v3-3/members")
//@CrossOrigin("http://127.0.0.1:5500")

public class MemberController3_3 {
    private Map<String, Member> memberStore = new HashMap<>();


    public MemberController3_3() {

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

    // 회원 생성
    @PostMapping
    public ResponseEntity<String> join(@RequestBody Member member) {
        // 레스트컨트롤러의 리턴방식은 무조건 리스폰스엔터티<타입>이다 생각하자

        //계정이 비어있는지 확인
        if (member.getAccount().isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body("계정은 필수값입니다.");
        }

        member.setUid(UUID.randomUUID().toString());
        memberStore.put(member.getUid(), member);
        return ResponseEntity
                .ok()
                .body("새로운 멤버가 생성됨! " + member.getNickname());

    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<?> list() { // ?로 제네릭의 형태를 열어둘수있다.

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("mypet", "dog");
        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new ArrayList<>(memberStore.values()));
    }
    // 단일조회 (계정명)
    @GetMapping("/{account}")
    public ResponseEntity<?> findById(@PathVariable String account){

        Member foundMember = memberStore.values()
                .stream()
                .filter(member -> member.getAccount().equals(account))
                .findFirst()
                .orElse(null);
        if(foundMember == null){
            return ResponseEntity
                    .status(404)
                    .body(account + "는 존재하지 않는 계정입니다.");
        }
        return ResponseEntity
               .ok()
               .body(foundMember);
    }





}
