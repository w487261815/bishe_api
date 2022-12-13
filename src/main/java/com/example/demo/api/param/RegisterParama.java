package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class RegisterParama implements Serializable {
    @ApiModelProperty(name = "user", value = "登录名")
    @NotEmpty(message = "登录名不能为空")
    private String user;

    @ApiModelProperty(name = "pass")
    @NotEmpty(message = "密码不能为空")
    private String pass;

    @ApiModelProperty(name = "age")
    @NotEmpty(message = "年龄不能为空")
    private String age;

    @ApiModelProperty(name = "name")
    @NotEmpty(message = "昵称不能为空")
    private String name;

    @ApiModelProperty(name = "tel")
    @NotEmpty(message = "电话不能为空")
    private String tel;

    @ApiModelProperty(name = "sex")
    @NotEmpty(message = "性别不能为空")
    private String sex;

    @ApiModelProperty(name = "registertime")
    @NotEmpty(message = "不能为空")
    private String registertime;
}
