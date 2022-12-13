package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UpdateUserParama implements Serializable {
    @ApiModelProperty(name = "username", value = "登录名")
    @NotEmpty(message = "登录名不能为空")
    private String newpass;

    @ApiModelProperty(name = "password", value = "用户密码(步需要MD5加密)")
    @NotEmpty(message = "密码不能为空")
    private String oldpass;

}
