package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class ShowAclyParam implements Serializable {
    @ApiModelProperty(name = "start", value = "页码")
    @NotEmpty(message = "页码不能为空")
    Integer start;
    @ApiModelProperty(name = "limit", value = "显示长度")
    @NotEmpty(message = "显示长度不能为空")
    Integer limit;
    @ApiModelProperty(name = "ConfigType", value = "配置类型，1.最新，2热门")
    @NotEmpty(message = "配置类型不能为空")
    Integer ConfigType;
    @ApiModelProperty(name = "content", value = "搜索内容，仅Config=3的时候触发")
    String  content;
}
