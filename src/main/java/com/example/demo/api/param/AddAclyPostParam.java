package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AddAclyPostParam implements Serializable {
    @ApiModelProperty(name = "id", value = "id")
    private Integer id;

    @ApiModelProperty(name = "uid", value = "用户id")
    private String uid;

    @ApiModelProperty(name = "comid", value = "id")
    private String comid;
}
