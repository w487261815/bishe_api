package com.example.demo.service;

import com.example.demo.api.param.RegisterParama;
import com.example.demo.entity.LoginEntity;
import com.example.demo.entity.RegisterEntity;
import com.example.demo.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    List<LoginEntity> Login(String username ,String password);
    List<UserInfoEntity> getInfo(String username);
    void updateName(String name,String uid);
    void updatePass(String password,String uid);
    void register(RegisterParama registerEntity);
    void addBase(RegisterParama registerEntity);
    void updateImg(String img_src,String uid);
    void updateCity(String city,String uid);
    void addpost(String uid);
}
