package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class UpdateImgParama implements Serializable {
    @ApiModelProperty(name = "imgSrc", value = "图片")
    @NotEmpty(message = "图片不能为空")
    private String imgSrc;
}
