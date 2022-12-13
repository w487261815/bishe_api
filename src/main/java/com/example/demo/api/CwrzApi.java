package com.example.demo.api;

import com.example.demo.api.param.AddCwrzParam;
import com.example.demo.api.param.ShowCityAnimalParam;
import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.CwrzEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.Impl.CommonServiceImpl;
import com.example.demo.service.Impl.CwrzServiceImpl;
import com.example.demo.util.Result;
import com.example.demo.util.ResultHandle;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/cwrz")
@Api(value = "v1", tags = "宠物认证相关接口\n")
public class CwrzApi {
    @Autowired
    CwrzServiceImpl cwrzService;
    @Autowired
    CommonServiceImpl commonService;
    @GetMapping("/select")
    public Result select(@TokenToAdminUser UserInfoEntity userInfoEntity){
        return new ResultHandle().getSuccessResult(cwrzService.select(userInfoEntity.getUid()));
    }

    @PostMapping("/add")
    public Result add(@TokenToAdminUser UserInfoEntity userInfoEntity,@RequestBody AddCwrzParam addCwrzParam){
        if(addCwrzParam.getAge()==null){
            return new ResultHandle().getFailResult("年龄不能为空");
        }
        if(addCwrzParam.getCity()==null||addCwrzParam.getCity()==""){
            return new ResultHandle().getFailResult("城市不能为空");
        }
        if(addCwrzParam.getImg()==null||addCwrzParam.getImg()==""){
            return new ResultHandle().getFailResult("图片不能为空");
        }
        if(addCwrzParam.getName()==null||addCwrzParam.getName()==""){
            return new ResultHandle().getFailResult("姓名不能为空");
        }
        if(addCwrzParam.getSex()==null||addCwrzParam.getSex()==""){
            return new ResultHandle().getFailResult("性别不能为空");
        }
        addCwrzParam.setIdenty(commonService.getTime());
        addCwrzParam.setUid(userInfoEntity.getUid());
        cwrzService.add(addCwrzParam);
        return new ResultHandle().getSuccessResult("SUCCESS");
    }

    @GetMapping("/show")
    public Result show(@TokenToAdminUser UserInfoEntity userInfoEntity,ShowCityAnimalParam page){
        if(page.getStart()==null||page.getLimit()==null){
            return new ResultHandle().getFailResult("分页参数出错");
        }
        if(page.getStart()<=0||page.getLimit()<0){
            return new ResultHandle().getFailResult("分页参数出错");
        }
        page.setStart(page.getStart()-1);
        page.setStart(page.getStart()*page.getLimit());
        page.setCity(userInfoEntity.getCity());

        List<CwrzEntity> cwrzEntityList = cwrzService.show(page);
        if(cwrzEntityList.size()==0){
            return new ResultHandle().getFailResult("没有下一页了");
        }
        return new ResultHandle().getSuccessResult(cwrzService.show(page));
    }

    @GetMapping("/shownewrz")
    public Result shownewrz(){
        return new ResultHandle().getSuccessResult(cwrzService.shownewRz());
    }
    @GetMapping("/showsexnum")
    public Result showsexnum(){
        return new ResultHandle().getSuccessResult(cwrzService.showsexnum());
    }
    @GetMapping("/showcitynum")
    public Result showcitynum(){
        return new ResultHandle().getSuccessResult(cwrzService.showcity());
    }
}
