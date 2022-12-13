package com.example.demo.service;

import com.example.demo.entity.YuceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PreviewService {
    List<YuceEntity> show(String uid);
    void add(@Param("yuceEntity") YuceEntity yuceEntity);
    void del(String id,String uid);
}
