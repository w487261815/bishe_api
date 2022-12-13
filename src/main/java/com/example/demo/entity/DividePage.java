package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DividePage {
    Integer start;
    Integer limit;
    Integer ConfigType;
    Integer ids;
    String used;
    Integer level;
    Integer id;
}
