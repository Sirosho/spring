package com.spring.basic.chap2_3.entity;


import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long serialNo;
    private String name;
    private int price;
}
