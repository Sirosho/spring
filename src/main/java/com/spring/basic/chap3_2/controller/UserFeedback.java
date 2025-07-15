package com.spring.basic.chap3_2.controller;

import com.spring.basic.chap3_2.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v3-2/feedbacks")
public class UserFeedback {


    List<User> userList = new ArrayList<>();
    @PostMapping
    public void UserRequest(@RequestBody User user) {

        User.builder()
                .uid("abc1234")
                .message("안녕하세요")
                .rating("5")
                .build();
        userList.add(user);
    }

    @GetMapping
    public List<User> getUser() {

        return userList;
    }


}
