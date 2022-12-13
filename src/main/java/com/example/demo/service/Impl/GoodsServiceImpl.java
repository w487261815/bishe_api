package com.example.demo.service.Impl;

import com.example.demo.api.vo.GoodsVo;
import com.example.demo.dao.GoodsMapper;
import com.example.demo.entity.DividePage;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "GoodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<GoodsVo> show(DividePage dividePage) {
        return goodsMapper.show(dividePage);
    }

    @Override
    public List<GoodsVo> showgoods(DividePage dividePage) {
        return goodsMapper.showgoods(dividePage);
    }

    @Override
    public List<GoodsVo> showtj() {
        return goodsMapper.showtj();
    }

    @Override
    public void addpost(Integer post, String uid) {
        goodsMapper.addpost(post,uid);
    }
}
