package com.example.demo.entity;

import com.example.demo.api.vo.GoodsVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DividePageEntity {
    List<GoodsVo> goodsData;
    Integer size;
}
