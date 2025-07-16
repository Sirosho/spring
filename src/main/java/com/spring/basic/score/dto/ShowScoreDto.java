package com.spring.basic.score.dto;

import com.spring.basic.score.entity.Score;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowScoreDto {
    private String maskingName;
    private int sum;
    private double avg;
    private int rank;


    public static List<ShowScoreDto> from(Map<Long,Score> scoreList) {

        List<Score> scoreListValue = scoreList.values()
                .stream()
                .collect(Collectors.toList());

        ArrayList<ShowScoreDto> showList = new ArrayList<>();

        for (Score score : scoreListValue) {
            ShowScoreDto showScoreDto = ShowScoreDto.builder()
                    .maskingName(score.getName())
                    .sum(score.getKor() + score.getEng() + score.getMath())
                    .avg(score.getKor() * 0.3 + score.getEng() * 0.3 + score.getMath() * 0.3)
                    .rank(scoreListValue.indexOf(score) + 1)
                    .build();
            showList.add(showScoreDto);

        }

        return showList;
    }
}
