package com.example.demo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVo {
    private String name;
    private int age;
    private String city;
    private int annum;
    private int post;
    private int lovernum;
    private String sex;
    private String imgSrc;
    private String tel;
    private String username;
    private String uid;
}
