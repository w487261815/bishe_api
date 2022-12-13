package com.example.demo.api;

import com.example.demo.api.param.AddAddressParam;
import com.example.demo.api.param.SetMorenParam;
import com.example.demo.api.vo.AddressVo;
import com.example.demo.api.vo.GoodsVo;
import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.DividePage;
import com.example.demo.entity.DividePageEntity;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.Impl.AddressServiceImpl;
import com.example.demo.util.Result;
import com.example.demo.util.ResultHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/address")
@Api(value = "v1", tags = "地址操作相关接口\n")
public class AddressApi {
    @Autowired
    AddressServiceImpl addressService;
    @GetMapping("/show")
    @ApiOperation(value = "展示")
    public Result select(@TokenToAdminUser UserInfoEntity userInfoEntity){
        return ResultHandle.getSuccessResult(addressService.show(userInfoEntity.getUid()));
    }
    @PutMapping("/changemoren")
    @ApiOperation(value = "设置默认")
    public Result changemoren(@TokenToAdminUser UserInfoEntity userInfoEntity, @RequestBody SetMorenParam setMorenParam){
        System.out.println(setMorenParam);
        List<AddressVo> addressVo = addressService.showById(setMorenParam.getAdid(),userInfoEntity.getUid());
        if(addressVo.size()==0) {
            return new ResultHandle().getFailResult("非法操作");
        }
        addressService.setMorenAll(userInfoEntity.getUid());
        addressService.setMoren(setMorenParam.getAdid());
        return ResultHandle.getSuccessResult("修改成功");
    }
    @PostMapping("/add")
    @ApiOperation(value = "新增地址")
    public Result changemoren(@TokenToAdminUser UserInfoEntity userInfoEntity, @RequestBody AddAddressParam addAddressParam){
        System.out.println(addAddressParam);
        addAddressParam.setUserid(userInfoEntity.getUid());
        if(addAddressParam.getAddress()==null||addAddressParam.getAddress()==""){
            return new ResultHandle().getFailResult("地址不能为空");
        }
        if(addAddressParam.getIsmoren()==null||addAddressParam.getIsmoren()==""){
            return new ResultHandle().getFailResult("是否默认不能为空");
        }
        if(addAddressParam.getName()==null||addAddressParam.getName()==""){
            return new ResultHandle().getFailResult("姓名不能为空");
        }
        if(addAddressParam.getTel()==null||addAddressParam.getTel()==""){
            return new ResultHandle().getFailResult("电话不能为空");
        }
        List<AddressVo> addressVos= addressService.show(userInfoEntity.getUid());
        System.out.println("addresssize"+addressVos.size());
        if(addressVos.size()>=4){
            return new ResultHandle().getFailResult("地址数量最多只能为4");
        }
        if(addAddressParam.getIsmoren().equals("true")){
            addressService.setMorenAll(userInfoEntity.getUid());
        }
        addressService.add(addAddressParam);
        return ResultHandle.getSuccessResult("添加成功");
    }

    @PostMapping("/del")
    @ApiOperation(value = "设置默认")
    public Result delete(@TokenToAdminUser UserInfoEntity userInfoEntity, @RequestBody SetMorenParam setMorenParam){
        System.out.println(setMorenParam);
        List<AddressVo> addressVo = addressService.showById(setMorenParam.getAdid(),userInfoEntity.getUid());
        if(addressVo.size()==0) {
            return new ResultHandle().getFailResult("非法操作");
        }
        addressService.del(setMorenParam.getAdid());
        return ResultHandle.getSuccessResult("SUCCESS");
    }
}
