package com.example.demo.dao;

import com.example.demo.api.vo.GoodsVo;
import com.example.demo.entity.DividePage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<GoodsVo> show(@Param("dividePage") DividePage dividePage);
    List<GoodsVo> showgoods(@Param("dividePage") DividePage dividePage);
    List<GoodsVo> showtj();
    void addpost(Integer post,String uid);
}
