package com.example.demo.service;

import com.example.demo.api.param.AddListParam;
import com.example.demo.api.param.ShowGwc;
import com.example.demo.entity.ListEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ListService {
    void add(@Param("addListParam") AddListParam addListParam);
    List<ListEntity> show(@Param("showGwc") ShowGwc showGwc);
    void changeSta(Integer listid,String uid);
    void del(Integer ids,String uid);
}
