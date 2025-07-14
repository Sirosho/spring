package com.spring.basic.chap2_4.entity;


import lombok.*;

@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Book {


    private Long id; // 책을 유일하게 구분할 수 있는 식별자 기본값을 null로 하기위해 래퍼케이스를 사용
    //@Setter 이렇게 위에 쓰면 title에만 세터 적용
    private String title;
    private String author;
    private int price;

    public void updateBookInfo(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
