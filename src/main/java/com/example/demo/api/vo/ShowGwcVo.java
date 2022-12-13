package com.example.demo.api.vo;

import com.example.demo.entity.ListEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShowGwcVo implements Serializable {
    @ApiModelProperty("页码")
    private Integer start;
    @ApiModelProperty("长度")
    private Integer limit;
    @ApiModelProperty("总数")
    private Integer size;
    @ApiModelProperty("数据")
    private List<ListEntity> gwcData;
}
