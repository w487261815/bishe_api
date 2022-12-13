package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class ChangeStaParam implements Serializable {
    @ApiModelProperty(name = "listid", value = "订单id")
    @NotEmpty(message = "订单id")
    private String listid;

    @ApiModelProperty(hidden = true)
    private String uid;
}
