package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class SetMorenParam implements Serializable {
    @ApiModelProperty(name = "adid", value = "id")
    @NotEmpty(message = "id不能为空")
    private String adid;
}
