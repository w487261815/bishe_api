package com.example.demo.dao;

import com.example.demo.entity.YuceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PreviewMapper {
    List<YuceEntity> show(String uid);
    void add(@Param("yuceEntity") YuceEntity yuceEntity);
    void del(String id,String uid);
}
