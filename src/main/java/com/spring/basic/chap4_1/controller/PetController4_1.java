package com.spring.basic.chap4_1.controller;

import com.spring.basic.chap4_1.entity.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chap4-1")
public class PetController4_1 {

    private static Long nextNo = 1L;

    private List<Pet> petList = new ArrayList<>();

    public PetController4_1() {
        petList.add(Pet.builder()
                .name("뽀삐")
                .age(3)
                .id(nextNo++)
                .kind("불독")
                .injection(true)
                .build());

        petList.add(Pet.builder()
                .name("초코")
                .age(4)
                .id(nextNo++)
                .kind("도베르만")
                .injection(false)
                .build());
        petList.add(Pet.builder()
                .name("나비")
                .age(1)
                .id(nextNo++)
                .kind("뱅갈호랑이")
                .injection(true)
                .build());
    }

    // pet.jsp를 열어줘! (뷰 포워딩)

    @GetMapping("/pet-page")
    public String petPage(Model model) { // 페이지 라우팅은 무조건 스트링
        // 서버사이드 렌더링을 위해 JSP 파일에게 리스트를 전달
        model.addAttribute("petList", petList);
        return "chap4-1/pet";
    }
}
