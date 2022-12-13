package com.example.demo.api.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@Data
public class AddAclyParam implements Serializable {
    @ApiModelProperty(name = "content", value = "内容")
    @NotEmpty(message = "内容不能为空")
    private String content;
    @ApiModelProperty(name = "title", value = "标题")
    @NotEmpty(message = "标题不能为空")
    private String title;
    @ApiModelProperty(name = "imgSrc", value = "图片1")
    private String imgSrc;
    @ApiModelProperty(name = "imgSrc1", value = "图片1")
    private String imgSrc1;
    @ApiModelProperty(name = "imgSrc2", value = "图片2")
    private String imgSrc2;
    @ApiModelProperty(hidden = true)
    private String uid;
    @ApiModelProperty(hidden = true)
    private String time;
}
