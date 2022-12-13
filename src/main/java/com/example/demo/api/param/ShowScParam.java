package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class ShowScParam implements Serializable {
    @ApiModelProperty(name = "img", value = "图片")
    @NotEmpty(message = "图片不能为空")
    private String img;
    @ApiModelProperty(name = "listid", value = "id")
    @NotEmpty(message = "id不能为空")
    private String listid;
}
