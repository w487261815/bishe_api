package com.example.demo.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsVo implements Serializable {
    @ApiModelProperty(name = "id")
    private int id;
    @ApiModelProperty(name = "type")
    private String type;
    @ApiModelProperty(name = "money")
    private int money;
    @ApiModelProperty(name = "uid")
    private int uid;
    @ApiModelProperty(name = "content")
    private String content;
    @ApiModelProperty(name = "img")
    private String img;
    @ApiModelProperty(name = "bianhao")
    private String bianhao;
    @ApiModelProperty(name = "tel")
    private String tel;
    @ApiModelProperty(name = "city")
    private String city;
    @ApiModelProperty(name = "age")
    private int age;
    @ApiModelProperty(name = "name")
    private String name;
    @ApiModelProperty(name = "post")
    private int post;
}
