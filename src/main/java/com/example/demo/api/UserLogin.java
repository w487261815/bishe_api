package com.example.demo.api;

import com.example.demo.api.param.*;
import com.example.demo.api.vo.UserInfoVo;
import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.LoginEntity;
import com.example.demo.entity.TokenEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.Impl.AnnimalTokenImpl;
import com.example.demo.service.Impl.CommonServiceImpl;
import com.example.demo.service.Impl.UserServiceImpl;
import com.example.demo.util.MD5Util;
import com.example.demo.util.Result;
import com.example.demo.util.ResultHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
@Api(value = "v1", tags = "用户操作相关接口\n")
public class UserLogin {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    AnnimalTokenImpl annimalToken;
    @Autowired
    CommonServiceImpl commonService;
    @PostMapping("/login")
    @ApiOperation(value = "登录接口", notes = "根据User对象登录")
//    @ApiImplicitParam(name = "username", value = "用户实体", required = true)
    public Result login(@RequestBody AnnimalUserLoginParam annimalUserLoginParam){
        if(annimalUserLoginParam.getUsername()==null||annimalUserLoginParam.getUsername().equals("")){
            return ResultHandle.getFailResult("用户名不能为空");
        }
        if(annimalUserLoginParam.getPassword()==null||annimalUserLoginParam.getPassword().equals("")){
            return ResultHandle.getFailResult("密码不能为空");
        }
        String md5Pass= MD5Util.MD5Encode(annimalUserLoginParam.getPassword(),"UTF-8");
        System.out.println(md5Pass);
        List<LoginEntity> s=userService.Login(annimalUserLoginParam.getUsername(),md5Pass);
        if(s.size()==1){
            String token=annimalToken.insert(annimalUserLoginParam.getUsername());
            TokenEntity tokens = new TokenEntity();
            tokens.setHeader("Annimal");
            tokens.setToken(token);
            return ResultHandle.getSuccessResult(tokens,"OK");
        }
        return ResultHandle.getFailResult("用户名或密码错误");
    }

    @GetMapping("/userinfo")
    @ApiOperation(value = "获取用户信息", notes = "根据Token获取用户信息")
    public Result userinfo(@TokenToAdminUser UserInfoEntity userInfoEntity){
        UserInfoVo userInfoVo=new UserInfoVo();
        userInfoVo.setAge(userInfoEntity.getAge());
        userInfoVo.setName(userInfoEntity.getName());
        userInfoVo.setCity(userInfoEntity.getCity());
        userInfoVo.setUsername(userInfoEntity.getUsername());
        userInfoVo.setAnnum(userInfoEntity.getAnnum());
        userInfoVo.setPost(userInfoEntity.getPost());
        userInfoVo.setLovernum(userInfoEntity.getLovernum());
        userInfoVo.setSex(userInfoEntity.getSex());
        userInfoVo.setImgSrc(userInfoEntity.getImgSrc());
        userInfoVo.setUid(userInfoEntity.getUid());
        userInfoVo.setTel(userInfoEntity.getTel());
        return ResultHandle.getSuccessResult(userInfoVo);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "退出登录", notes = "根据Token获取用户信息")
    public Result logout(@TokenToAdminUser UserInfoEntity userInfoEntity){
        System.out.println(userInfoEntity);
        annimalToken.delelteUsername(userInfoEntity.getToken());
        return ResultHandle.getSuccessResult("退出成功");
    }
    @PutMapping("/updatepass")
    @ApiOperation(value = "修改密码", notes = "根据Token获取用户信息")
    public Result updatepass(@TokenToAdminUser UserInfoEntity userInfoEntity, @RequestBody  UpdateUserParama updateUserParama){
        //if(oldpass!=userInfoEntity)
        System.out.println(updateUserParama);
        if(updateUserParama.getOldpass()==null||updateUserParama.getOldpass()==""){
            return ResultHandle.getFailResult("请输入旧密码");
        }
        if(updateUserParama.getNewpass()==null||updateUserParama.getNewpass()==""){
            return ResultHandle.getFailResult("请输入新密码");
        }
        if(updateUserParama.getNewpass().length()<6||updateUserParama.getNewpass().length()>16){
            return ResultHandle.getFailResult("请输入6-16位的密码");
        }
        String md5Pass= MD5Util.MD5Encode(updateUserParama.getOldpass(),"UTF-8");
        if(!md5Pass.equals(userInfoEntity.getPassword())){
            return ResultHandle.getFailResult("原始密码错误");
        }
        String newPass=MD5Util.MD5Encode(updateUserParama.getNewpass(),"UTF-8");
        System.out.println(md5Pass+"  "+userInfoEntity.getUid());
        userService.updatePass(newPass,userInfoEntity.getUid());
        return ResultHandle.getSuccessResult("修改成功");
    }

    @PutMapping("/updatename")
    @ApiOperation(value = "修改名称", notes = "根据Token获取用户信息")
    public Result updateName(@TokenToAdminUser UserInfoEntity userInfoEntity, @RequestBody UpdateNameParams updateNameParams){
        if(updateNameParams.getName()==null||updateNameParams.getName()==""){
            return ResultHandle.getFailResult("请输入名称");
        }
        System.out.println(updateNameParams.getName());
        if(updateNameParams.getName().length()>8){
            return ResultHandle.getFailResult("名称不能超过八位");
        }
        userService.updateName(updateNameParams.getName(),userInfoEntity.getUid());
        return ResultHandle.getSuccessResult("修改成功");
    }

    @GetMapping("/register")
    @ApiOperation(value = "用户注册", notes = "根据Token获取用户信息")
    public Result Register(RegisterParama registerParama){
        System.out.println(registerParama);
        if(registerParama.getName()==null||registerParama.getName()==""){
            return ResultHandle.getFailResult("请输入名称");
        }
        if(registerParama.getAge()==null||registerParama.getAge()==""){
            return ResultHandle.getFailResult("请输入年龄");
        }
        if(registerParama.getUser()==null||registerParama.getUser()==""){
            return ResultHandle.getFailResult("请输入用户名");
        }
        if(registerParama.getPass()==null||registerParama.getPass()==""){
            return ResultHandle.getFailResult("请输入密码");
        }
        if(registerParama.getSex()==null||registerParama.getSex()==""){
            return ResultHandle.getFailResult("请输入性别");
        }
        if(registerParama.getTel()==null||registerParama.getTel()==""){
            return ResultHandle.getFailResult("请输入电话");
        }
        if(registerParama.getPass().length()<6||registerParama.getPass().length()>16){
            return ResultHandle.getFailResult("请输入6-16位密码");
        }
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUsername("-1");
        List<LoginEntity> ue=userService.Login(registerParama.getUser(),"-1");
        if(ue.size()>0){
            return ResultHandle.getFailResult("用户名已被注册");
        }
        registerParama.setRegistertime(commonService.getTime());
        String md5Pass= MD5Util.MD5Encode(registerParama.getPass(),"UTF-8");
        registerParama.setPass(md5Pass);
        userService.register(registerParama);
        userService.addBase(registerParama);
        String token=annimalToken.insert(registerParama.getUser());
        TokenEntity tokens = new TokenEntity();
        tokens.setHeader("Annimal");
        tokens.setToken(token);
        return ResultHandle.getSuccessResult(tokens,"OK");
    }

    @PutMapping("/updateimg")
    @ApiOperation(value = "修改名称", notes = "根据Token获取用户信息")
    public Result updateName(@TokenToAdminUser UserInfoEntity userInfoEntity,@RequestBody UpdateImgParama updateImgParama){
        commonService.deleteImg(userInfoEntity.getImgSrc());
        System.out.println(updateImgParama.getImgSrc()+"  "+userInfoEntity.getUid());
        userService.updateImg(updateImgParama.getImgSrc(),userInfoEntity.getUid());
        return ResultHandle.getSuccessResult("修改成功");
    }

    @PutMapping("/updatecity")
    @ApiOperation(value = "修改名称", notes = "根据Token获取用户信息")
    public Result updatCity(@TokenToAdminUser UserInfoEntity userInfoEntity,@RequestBody UpdateCityParams updateCityParams){
        if(updateCityParams.getCity()==null||updateCityParams.getCity()==""){
            return ResultHandle.getFailResult("城市不能为空");
        }
        userService.updateCity(updateCityParams.getCity(),userInfoEntity.getUid());
        return ResultHandle.getSuccessResult("修改成功");
    }
}
