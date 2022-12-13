package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UpdateCityParams implements Serializable {
    @ApiModelProperty(name = "city", value = "城市")
    @NotEmpty(message = "城市不能为空")
    private String city;
}
