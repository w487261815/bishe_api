package com.example.demo.dao;

import com.example.demo.api.param.AddCwrzParam;
import com.example.demo.api.param.ShowCityAnimalParam;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.CwrzEntity;
import com.example.demo.entity.ShowSexNumEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CwrzMapper {
    List<CwrzEntity> select(String uid);
    void add(@Param("cwrzParam") AddCwrzParam cwrzParam);
    List<CwrzEntity> show(@Param("showCityAnimalParam") ShowCityAnimalParam showCityAnimalParam);
    List<CwrzEntity> shownewRz();
    List<ShowSexNumEntity> showsexnum();
    List<CityEntity> showcity();
}
