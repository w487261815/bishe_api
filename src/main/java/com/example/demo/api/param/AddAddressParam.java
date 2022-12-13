package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AddAddressParam implements Serializable {
    @ApiModelProperty(name = "address", value = "地址")
    @NotEmpty(message = "地址不能为空")
    private String address;

    @ApiModelProperty(name = "ismoren", value = "是否默认")
    @NotEmpty(message = "是否默认不能为空")
    private String ismoren;

    @ApiModelProperty(name = "name", value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @ApiModelProperty(name = "tel", value = "手机号码")
    @NotEmpty(message = "手机号码不能为空")
    private String tel;

    @ApiModelProperty(hidden = true)
    private String userid;
}
