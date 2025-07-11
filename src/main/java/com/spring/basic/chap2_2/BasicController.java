package com.spring.basic.chap2_2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // JSP같은 뷰를 핸들링하는 컨트롤러
                // 이경우 밑의 리턴을 경로로 인식하여 찾게된다.

@RestController // Controller + ResponseBody 이다. 안에 들어가보면 둘 다 있음
@RequestMapping("/chap2-2")//공통 URL을 지정
public class BasicController {

    /*
    *
    *   GET     : 조회
    *   POST    : 생성
    *   PUT     : 수정
    *   DELETE  : 삭제
    *
    * */


        // 핸들러 메서드 (각 요청을 전담처리)
//    @RequestMapping(value= "/chap2-2/hello",method = RequestMethod.GET) // GET 요청만 받을거야
//    @ResponseBody // 그냥 컨트롤러에 이걸 붙이면 JSON을 내보냄

    @GetMapping("/hello")// @RequestMapping(value= "/chap2-2/hello",method = RequestMethod.GET) 이걸 줄임
    public String hello(){
        return "hello spring";
    }
//    curl.exe -X GET "http://localhost:9000/chap2-2/hello" 터미널에서 이걸로 확인가능
// 주소창 a태그 요청은 GET이다
    // 다른것들은 fetch로 보내야 한다.

    @PostMapping("/hobby")
    public List<String> greet(){
        return List.of("수영","축구","낮잠","시비걸기");
    }


}
