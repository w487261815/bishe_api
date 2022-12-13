package com.example.demo.service.Impl;

import com.example.demo.api.param.RegisterParama;
import com.example.demo.dao.AnnimalUserMapper;
import com.example.demo.entity.LoginEntity;
import com.example.demo.entity.RegisterEntity;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    AnnimalUserMapper annimalUserMapper;

    @Override
    public List<LoginEntity> Login(String username, String password) {
        return annimalUserMapper.Login(username,password);
    }

    @Override
    public List<UserInfoEntity> getInfo(String username) {
        return annimalUserMapper.getInfo(username);
    }

    @Override
    public void updateName(String name, String uid) {
        annimalUserMapper.updateName(name,uid);
    }

    @Override
    public void updatePass(String password, String uid) {
        annimalUserMapper.updatePass(password,uid);
    }

    @Override
    public void register(RegisterParama registerEntity) {
        annimalUserMapper.register(registerEntity);
    }

    @Override
    public void addBase(RegisterParama registerEntity) {
        annimalUserMapper.addBase(registerEntity);
    }

    @Override
    public void updateImg(String img_src, String uid) {
        annimalUserMapper.updateImg(img_src,uid);
    }

    @Override
    public void updateCity(String city, String uid) {
        annimalUserMapper.updateCity(city,uid);
    }

    @Override
    public void addpost(String uid) {
        annimalUserMapper.addpost(uid);
    }

}
