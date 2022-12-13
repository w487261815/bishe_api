package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class ShowCityAnimalParam implements Serializable {
    @ApiModelProperty(name = "start", value = "页码")
    @NotEmpty(message = "页码不能为空")
    Integer start;
    @ApiModelProperty(name = "limit", value = "显示长度")
    @NotEmpty(message = "显示长度不能为空")
    Integer limit;
    @ApiModelProperty(hidden = true)
    String  city;
}
