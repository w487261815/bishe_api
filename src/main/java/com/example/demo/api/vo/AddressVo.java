package com.example.demo.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressVo implements Serializable {
    @ApiModelProperty(name = "userid")
    private int userid;
    @ApiModelProperty(name = "name")
    private String name;
    @ApiModelProperty(name = "tel")
    private String tel;
    @ApiModelProperty(name = "address")
    private String address;
    @ApiModelProperty(name = "adid")
    private int adid;
    @ApiModelProperty(name = "ismoren")
    private String ismoren;
}
