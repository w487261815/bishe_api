package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class ShowGwc implements Serializable {
    @ApiModelProperty(name = "status", value = "状态码,-1是全部，0未付款，1已付款")
    @NotEmpty(message = "状态码不能为空")
    Integer status;
    @ApiModelProperty(name = "start", value = "页码")
    @NotEmpty(message = "页码不能为空")
    Integer start;
    @ApiModelProperty(name = "limit", value = "显示长度")
    @NotEmpty(message = "显示长度不能为空")
    Integer limit;
    @ApiModelProperty(hidden = true)
    String uid;
}
