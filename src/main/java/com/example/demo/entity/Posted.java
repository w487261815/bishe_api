package com.example.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Posted {
    private Integer id;
    private Integer uid;
    private String comid;
    private String list;
    private String[] user_list;
}
