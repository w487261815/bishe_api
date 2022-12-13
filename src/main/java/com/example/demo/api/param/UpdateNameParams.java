package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class UpdateNameParams implements Serializable {
    @ApiModelProperty(name = "name", value = "昵称")
    @NotEmpty(message = "名称不能为空")
    private String name;
}
