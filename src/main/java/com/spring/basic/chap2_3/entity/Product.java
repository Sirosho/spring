package com.spring.basic.chap2_3.entity;


import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

// @Data
// 는 위의것을 전부 만들어주지만 실무에서는 게터나 세터가 없는경우가 있으니 위처럼 명시해서 다적어주자
public class Product {

    private Long serialNo; // 상품시리얼번호
    private String anme;// 상품명
    private int price; // 상품 가격

}
