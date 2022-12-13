package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class AddListParam implements Serializable {
    @ApiModelProperty(name = "productId", value = "地址")
    @NotEmpty(message = "商品ID不能为空")
    private String productId;

    @ApiModelProperty(name = "status", value = "1为购买 0为添加购物车")
    @NotEmpty(message = "状态码不能为空")
    private String status;

    @ApiModelProperty(hidden = true)
    private String userid;

    @ApiModelProperty(hidden = true)
    private String identy;

    @ApiModelProperty(hidden = true)
    private String cityid;

}
