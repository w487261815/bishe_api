package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CwrzEntity {
    int id;
    String userid;
    String name;
    String sex;
    String city;
    int age;
    String img;
    String identy;
    String uname;
    String tel;
}
