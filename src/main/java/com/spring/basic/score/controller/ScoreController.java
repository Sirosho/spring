package com.spring.basic.score.controller;


import com.spring.basic.score.dto.ShowScoreDto;
import com.spring.basic.score.entity.Score;
import com.spring.basic.score.repository.ScoreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/api/v1/scores")
public class ScoreController {


    @GetMapping()
    public String viewScores(){
        return "score/score-page";
    }

    @GetMapping("?sort=id")
    @ResponseBody
    public List<ShowScoreDto> showScores(){

        ScoreRepository scoreRepository = new ScoreRepository();
        Map<Long,Score> studentList = scoreRepository.getStudentList();
        return ShowScoreDto.from(studentList);

    }

}
