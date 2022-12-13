package com.example.demo.service;

import com.example.demo.api.param.AddAclyParam;
import com.example.demo.api.param.ShowAclyParam;
import com.example.demo.entity.AclyEntity;
import com.example.demo.entity.Posted;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AclyService {
    List<AclyEntity> show(@Param("showAclyParam") ShowAclyParam showAclyParam);
    void add(@Param("addAclyParam") AddAclyParam addAclyParam);
    void addpost(String id);
    List<Posted> getPosted(Integer uid, Integer comid);
    void updatePosted(@Param("posted") Posted posted);
    void addPosted(@Param("posted") Posted posted);
}
