package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEntity {
    private String user;
    private String pass;
    private String age;
    private String name;
    private String sex;
    private String tel;
    private String registertime;
}
