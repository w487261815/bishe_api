package com.example.demo.service.Impl;

import com.example.demo.api.param.AddCwrzParam;
import com.example.demo.api.param.ShowCityAnimalParam;
import com.example.demo.dao.CwrzMapper;
import com.example.demo.entity.CityEntity;
import com.example.demo.entity.CwrzEntity;
import com.example.demo.entity.ShowSexNumEntity;
import com.example.demo.service.CwrzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("CwrzServiceImpl")
public class CwrzServiceImpl implements CwrzService {
    @Autowired
    CwrzMapper cwrzMapper;

    @Override
    public List<CwrzEntity> select(String uid) {
        return cwrzMapper.select(uid);
    }

    @Override
    public void add(AddCwrzParam cwrzParam) {
        cwrzMapper.add(cwrzParam);
    }

    @Override
    public List<CwrzEntity> show(ShowCityAnimalParam showCityAnimalParam) {
        return cwrzMapper.show(showCityAnimalParam);
    }

    @Override
    public List<CwrzEntity> shownewRz() {
        return cwrzMapper.shownewRz();
    }

    @Override
    public List<ShowSexNumEntity> showsexnum() {
        return cwrzMapper.showsexnum();
    }

    @Override
    public List<CityEntity> showcity() {
        return cwrzMapper.showcity();
    }
}
