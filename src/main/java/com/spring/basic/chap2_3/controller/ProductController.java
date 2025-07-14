package com.spring.basic.chap2_3.controller;


import com.spring.basic.chap2_3.entity.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    // 가상의 메모리 상품 저장소

    private Map<Long, Product> productMap = new HashMap<>();

    // 상품의 시리얼 넘버 순차생성
    private long nextId = 1;


    public ProductController() {
        productMap.put(nextId, new Product(nextId, "에어컨", 1000000));
        nextId++;
        productMap.put(nextId, new Product(nextId, "세탁기", 1500000));
        nextId++;
        productMap.put(nextId, new Product(nextId, "공기청정기", 300000));
        nextId++;
    }

    // 특정 상품 조회 : GET

//    @GetMapping
//    public Product getProduct(HttpServletRequest req){
//        String id = req.getParameter("id");
//        return productMap.get(Long.parseLong(id));
//    }

    @GetMapping             // 변수명과 쿼리가 같으면 어노테이션 생략가능
    public Product getProduct(@RequestParam("id") long hey,
                              @RequestParam(value="price",required=false,defaultValue="1000" ) int price

    ){
        return productMap.get(hey);
    }

    // localhost:9000/products/1    -> 1번 상품 조회
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        return productMap.get(id);
    }






}
