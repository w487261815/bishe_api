package com.example.demo.api;

import com.example.demo.api.param.AddListParam;
import com.example.demo.api.param.ChangeStaParam;
import com.example.demo.api.param.CommonIdsParam;
import com.example.demo.api.param.ShowGwc;
import com.example.demo.api.vo.AddressVo;
import com.example.demo.api.vo.ShowGwcVo;
import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.DividePage;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.AddressService;
import com.example.demo.service.Impl.AddressServiceImpl;
import com.example.demo.service.Impl.CommonServiceImpl;
import com.example.demo.service.Impl.ListServiceImpl;
import com.example.demo.util.Result;
import com.example.demo.util.ResultHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/list")
@Api(value = "v1", tags = "订单列表相关接口\n")
public class ListApi {
    @Autowired
    ListServiceImpl listService;
    @Autowired
    CommonServiceImpl commonService;
    @Autowired
    AddressServiceImpl addressService;
    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public Result addgoods(@TokenToAdminUser UserInfoEntity userInfoEntity, @RequestBody AddListParam addListParam){
        System.out.println(addListParam);
        if(addListParam.getProductId()==null||addListParam.getStatus()==null){
            return ResultHandle.getFailResult("参数非法");
        }
        Integer flag=0;
        Integer id=0;
        List<AddressVo> addressVo = addressService.show(userInfoEntity.getUid());
        for(int i=0;i<addressVo.size();i++){
            if(addressVo.get(i).getIsmoren().equals("true")){
                flag=1;
                id=addressVo.get(i).getAdid();
                break;
            }
        }
        if(flag==0){
            return ResultHandle.getFailResult("你没有设置默认地址");
        }
        addListParam.setCityid(String.valueOf(id));
        addListParam.setIdenty(commonService.getImgName());
        addListParam.setUserid(userInfoEntity.getUid());
        listService.add(addListParam);
        return ResultHandle.getSuccessResult("SUCCESS");
    }

    @GetMapping("/show")
    @ApiOperation(value = "展示")
    public Result show(@TokenToAdminUser UserInfoEntity userInfoEntity, ShowGwc page){
        if(page.getStart()==null||page.getLimit()==null){
            return new ResultHandle().getFailResult("分页参数出错");
        }
        if(page.getStart()<=0||page.getLimit()<0){
            return new ResultHandle().getFailResult("分页参数出错");
        }
        System.out.println(page);
        page.setStart(page.getStart()-1);
        page.setStart(page.getStart()*page.getLimit());
        page.setUid(userInfoEntity.getUid());
        ShowGwcVo showGwcVo = new ShowGwcVo();
        showGwcVo.setLimit(page.getLimit());
        showGwcVo.setStart(page.getStart());
        showGwcVo.setGwcData(listService.show(page));
        page.setStart(0);
        page.setLimit(999999);
        showGwcVo.setSize(listService.show(page).size());
        return ResultHandle.getSuccessResult(showGwcVo);
    }

    @PutMapping("/changstatus")
    @ApiOperation(value = "修改")
    public Result changstatus(@TokenToAdminUser UserInfoEntity userInfoEntity,@RequestBody ChangeStaParam changeStaParam){
        changeStaParam.setUid(userInfoEntity.getUid());
        listService.changeSta(Integer.parseInt(changeStaParam.getListid()),changeStaParam.getUid());
        return ResultHandle.getSuccessResult("SUCCESS");
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除")
    public Result del(@TokenToAdminUser UserInfoEntity userInfoEntity,@RequestBody CommonIdsParam commonIds){
        if(commonIds.getIds()==null){
            return ResultHandle.getFailResult("操作非法");
        }
        for(int i=0;i<commonIds.getIds().length;i++){
            Integer id = commonIds.getIds()[i];
            listService.del(id,userInfoEntity.getUid());
        }
        return ResultHandle.getSuccessResult("SUCCESS");
    }
}
