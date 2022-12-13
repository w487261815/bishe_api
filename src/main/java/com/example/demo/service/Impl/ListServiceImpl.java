package com.example.demo.service.Impl;

import com.example.demo.api.param.AddListParam;
import com.example.demo.api.param.ShowGwc;
import com.example.demo.dao.ListMapper;
import com.example.demo.entity.ListEntity;
import com.example.demo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ListServiceImpl")
public class ListServiceImpl implements ListService {
    @Autowired
    ListMapper listMapper;
    @Override
    public void add(AddListParam addListParam) {
        listMapper.add(addListParam);
    }

    @Override
    public List<ListEntity> show(ShowGwc showGwc) {
        return listMapper.show(showGwc);
    }

    @Override
    public void changeSta(Integer listid, String uid) {
        listMapper.changeSta(listid,uid);
    }

    @Override
    public void del(Integer ids, String uid) {
        listMapper.del(ids,uid);
    }
}
