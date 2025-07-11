package com.spring.basic.chap2_3.controller;


import com.spring.basic.chap2_3.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController // JSON 처리
@RequestMapping("/products")
public class ProductController {

    // 가상의 메모리 상품 저장소

    private Map<Long, Product> productMap = new HashMap<>();

    // 상품의 시리얼넘버 순차생성
    private long nextId = 1;

    public ProductController(){

        productMap.put(nextId,new Product(nextId, "에어컨", 1000000));
        nextId++;
        productMap.put(nextId,new Product(nextId, "세탁기", 1500000));
        nextId++;
        productMap.put(nextId,new Product(nextId, "공기청정기", 3000000));
        nextId++;
    }

//    // 특정 상품 조회 : GET
//      방식 1
//
//    @GetMapping
//    public Product getProduct(HttpServletRequest req){
//        String id = req.getParameter("id");
//        return productMap.get(Long.parseLong(id));
//    }


    // 특정 상품 조회 : GET

    @GetMapping          // 이게 숨어져 있다 리퀘스트 파라미터와 변수이름이 같으면 생략가능
    public Product getProduct(
            @RequestParam("id")long id,//두개를 지정해두고 요청을 안받으면 에러가 남
            @RequestParam(value = "price", required = false, defaultValue = "1000")
            int price// 하지만 위에처럼 리콰이어드 속성 적으면 괜춘
    ){
        return productMap.get(id);
    }



}
