package com.example.demo.service.Impl;

import com.example.demo.dao.PreviewMapper;
import com.example.demo.entity.YuceEntity;
import com.example.demo.service.PreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PreviewServiceImpl")
public class PreviewServiceImpl implements PreviewService {
    @Autowired
    PreviewMapper previewMapper;

    @Override
    public List<YuceEntity> show(String uid) {
        return previewMapper.show(uid);
    }

    @Override
    public void add(YuceEntity yuceEntity) {
        previewMapper.add(yuceEntity);
    }

    @Override
    public void del(String id, String uid) {
        previewMapper.del(id,uid);
    }


}
