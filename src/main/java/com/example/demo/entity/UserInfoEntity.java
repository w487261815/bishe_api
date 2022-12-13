package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoEntity {
    private String name;
    private int age;
    private String city;
    private int annum;
    private int post;
    private int lovernum;
    private String sex;
    private String registertime;
    private String imgSrc;
    private String tel;
    private String token;
    private String username;
    private String uid;
    private String password;
}
