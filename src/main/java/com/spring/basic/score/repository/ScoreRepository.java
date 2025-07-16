package com.spring.basic.score.repository;

import com.spring.basic.score.entity.Score;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreRepository {

    private Long nextId = 1L;
    private Map<Long,Score> studentList =
            new HashMap<>(Map.of(
                    nextId++,new Score(nextId++, "김복복", 90, 100, 90),
                    nextId++,new Score(nextId++, "박수포자", 90, 30, 20),
                    nextId++,new Score(nextId++, "김아모르겠다클", 90, 80, 70),
                    nextId++,new Score(nextId++, "세종대왕", 95, 30, 70)
            ));

    public void addScore(Score score) {
        studentList.put(nextId++,score);

    }
    public Map<Long,Score> getStudentList(){
        return studentList;
    }
}
