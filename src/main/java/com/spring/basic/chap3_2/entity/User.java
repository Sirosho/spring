package com.spring.basic.chap3_2.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String uid;
    private String message;
    private String rating;
}
