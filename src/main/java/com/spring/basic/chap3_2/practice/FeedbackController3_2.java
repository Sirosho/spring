package com.spring.basic.chap3_2.practice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v3-2/feedback")
public class FeedbackController3_2 {

    private List<Feedback> feedbackList = new ArrayList<>();
    @GetMapping
    public List<Feedback> feedbackList(){
        return feedbackList;
    }

    @PostMapping
    public String createFeedback(@RequestBody Feedback feedback){
        feedbackList.add(feedback);
        return "Feedback created!" + feedback;
    }

}
