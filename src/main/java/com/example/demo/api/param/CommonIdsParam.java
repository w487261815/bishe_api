package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class CommonIdsParam implements Serializable {
    @ApiModelProperty(name = "ids", value = "数组id")
    Integer[] ids;
}
