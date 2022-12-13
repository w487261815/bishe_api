package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class AddCwrzParam implements Serializable {
    @ApiModelProperty(name = "name", value = "名字")
    @NotEmpty(message = "名字不能为空")
    private String name;

    @ApiModelProperty(name = "sex", value = "名字")
    @NotEmpty(message = "性别不能为空")
    private String sex;

    @ApiModelProperty(name = "age", value = "年龄")
    @NotEmpty(message = "年龄不能为空")
    private Integer age;

    @ApiModelProperty(name = "city", value = "城市")
    @NotEmpty(message = "城市不能为空")
    private String city;

    @ApiModelProperty(name = "img", value = "城市")
    @NotEmpty(message = "图片不能为空")
    private String img;

    @ApiModelProperty(hidden = true)
    private String uid;

    @ApiModelProperty(hidden = true)
    private String identy;
}
