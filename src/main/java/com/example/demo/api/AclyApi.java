package com.example.demo.api;

import com.example.demo.api.param.AddAclyParam;
import com.example.demo.api.param.AddAclyPostParam;
import com.example.demo.api.param.ShowAclyParam;
import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.Posted;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.Impl.AclyServiceImpl;
import com.example.demo.service.Impl.CommonServiceImpl;
import com.example.demo.service.Impl.UserServiceImpl;
import com.example.demo.util.Result;
import com.example.demo.util.ResultHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/acly")
@Api(value = "v1", tags = "爱宠乐园相关接口\n")
public class AclyApi {
    @Autowired
    AclyServiceImpl aclyService;
    @Autowired
    CommonServiceImpl commonService;
    @Autowired
    UserServiceImpl userService;
    @GetMapping("/show")
    @ApiOperation(value = "展示评论")
    public Result select(@TokenToAdminUser UserInfoEntity userInfoEntity, ShowAclyParam page){
        System.out.println(page);
        if(page.getStart()==null||page.getLimit()==null){
            return new ResultHandle().getFailResult("分页参数出错");
        }
        if(page.getStart()<0||page.getLimit()<0){
            return new ResultHandle().getFailResult("分页参数出错");
        }
        return ResultHandle.getSuccessResult(aclyService.show(page));
    }
    @PostMapping("/addlist")
    @ApiOperation(value = "添加评论")
    public Result addlist(@TokenToAdminUser UserInfoEntity userInfoEntity, @RequestBody AddAclyParam addAclyParam){
        if(addAclyParam.getContent()==null||addAclyParam.getContent()==""){
            return new ResultHandle().getFailResult("内容不能为空");
        }
        if(addAclyParam.getTitle()==null||addAclyParam.getTitle()==""){
            return new ResultHandle().getFailResult("标题不能为空");
        }
        addAclyParam.setTime(commonService.getTime());
        addAclyParam.setUid(userInfoEntity.getUid());
        aclyService.add(addAclyParam);
        return ResultHandle.getSuccessResult("SUCCESS");
    }
    @PutMapping("/addpost")
    @ApiOperation(value = "点赞操作")
    @ApiImplicitParam(name = "Authorization", value = "用户令牌", required = true,paramType="header")
    public Result addpost(@TokenToAdminUser UserInfoEntity userEntity, @RequestBody AddAclyPostParam param){
        System.out.println(param);
        if(param.getUid()==null){
            return ResultHandle.getFailResult("非法访问");
        }
        if(param.getUid().equals(userEntity.getUid())){
            return ResultHandle.getFailResult("你不能给你自己点赞");
        }
        List<Posted> posteds = aclyService.getPosted(find_bound(Integer.parseInt(userEntity.getUid())),Integer.parseInt(param.getComid()));
        System.out.println(posteds);
        if(posteds.size()>0) {
            String ids[] = posteds.get(0).getList().split(" ");
            for (String id : ids) {
                if (id.equals(String.valueOf(userEntity.getUid()))) {
                    return ResultHandle.getFailResult("你已经点赞过了");
                }
            }
            posteds.get(0).setList(posteds.get(0).getList()+" "+userEntity.getUid());
            aclyService.updatePosted(posteds.get(0));
            aclyService.addpost(String.valueOf(param.getId()));
            userService.addpost(String.valueOf(param.getUid()));
            return ResultHandle.getSuccessResult("OK");
        }
        Posted posted = new Posted();
        posted.setList(String.valueOf(userEntity.getUid()));
        posted.setComid(param.getComid());
        posted.setUid(find_bound(Integer.parseInt(userEntity.getUid())));
        aclyService.addPosted(posted);
        aclyService.addpost(String.valueOf(param.getId()));
        userService.addpost(String.valueOf(param.getUid()));
        return ResultHandle.getSuccessResult("OK");
    }

    public int find_bound(int num){
        if(num%50==0){
            return num-50;
        }else{
            return (num/50)*50;
        }
    }
}
