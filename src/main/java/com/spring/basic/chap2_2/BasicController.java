package com.spring.basic.chap2_2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // JSP같은 뷰를 핸들링하는 컨트롤러
@RestController // JSON을 리턴하는 컨트롤러
@RequestMapping("/chap2-2") // 공통 URL
public class BasicController {

    /*
    *   GET : 조회
    *   POST : 생성
    *   PUT : 수정
    *   DELETE : 삭제
    * */

    // 핸들러 메서드 (각 요청을 전담처리)

//    @RequestMapping(value="/chap2-2/hello",method= RequestMethod.GET) // 요청방식 제한
    @GetMapping("/hello") // get만 받겠다
    public String hellasdasdo() {

        return "hello Spring";
    }
    @PostMapping("/hobby")
    public List<String> hobby(){
        return List.of("수영","축구","낮잠","시비걸기");
    }


}
