package com.example.demo.service.Impl;

import com.example.demo.api.param.AddAclyParam;
import com.example.demo.api.param.ShowAclyParam;
import com.example.demo.dao.AclyMapper;
import com.example.demo.entity.AclyEntity;
import com.example.demo.entity.Posted;
import com.example.demo.service.AclyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "AclyServiceImpl")
public class AclyServiceImpl implements AclyService {
    @Autowired
    AclyMapper aclyMapper;
    @Override
    public List<AclyEntity> show(ShowAclyParam showAclyParam) {
        return aclyMapper.show(showAclyParam);
    }

    @Override
    public void add(AddAclyParam addAclyParam) {
        aclyMapper.add(addAclyParam);
    }

    @Override
    public void addpost(String id) {
        aclyMapper.addpost(id);
    }

    @Override
    public List<Posted> getPosted(Integer uid, Integer comid) {
        return aclyMapper.getPosted(uid,comid);
    }

    @Override
    public void updatePosted(Posted posted) {
        aclyMapper.updatePosted(posted);
    }

    @Override
    public void addPosted(Posted posted) {
        aclyMapper.addPosted(posted);
    }


}
