package com.example.demo.api;

import com.example.demo.api.vo.GoodsVo;
import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.DividePage;
import com.example.demo.entity.DividePageEntity;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.service.Impl.GoodsServiceImpl;
import com.example.demo.util.Result;
import com.example.demo.util.ResultHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/goods")
@Api(value = "v1", tags = "商品相关接口\n")
public class GoodsApi {
    @Autowired
    GoodsServiceImpl goodsService;

    @GetMapping("/select")
    @ApiOperation(value = "展示")
    public Result select(@TokenToAdminUser UserInfoEntity userInfoEntity, DividePage page){
        if(page.getStart()==null||page.getLimit()==null){
            return new ResultHandle().getFailResult("分页参数出错");
        }
        if(page.getStart()<=0||page.getLimit()<0){
            return new ResultHandle().getFailResult("分页参数出错");
        }
        page.setStart(page.getStart()-1);
        page.setStart(page.getStart()*page.getLimit());
        DividePageEntity dp=new DividePageEntity();
        List<GoodsVo> ce=goodsService.show(page);
        dp.setGoodsData(ce);
        page.setStart(0);
        page.setLimit(9999999);
        dp.setSize(goodsService.show(page).size());
        return ResultHandle.getSuccessResult(dp);
    }
    @GetMapping("/showgood")
    @ApiOperation(value = "展示")
    public Result showgood(@TokenToAdminUser UserInfoEntity userInfoEntity, DividePage page){
        page.setStart(0);
        page.setLimit(10);
        page.setIds(page.getId());

        return ResultHandle.getSuccessResult(goodsService.showgoods(page));
    }
    @GetMapping("/showtj")
    @ApiOperation(value = "展示")
    public Result showgood(@TokenToAdminUser UserInfoEntity userInfoEntity){
        return ResultHandle.getSuccessResult(goodsService.showtj());
    }
    @GetMapping("/addpost")
    @ApiOperation(value = "展示")
    public Result addpost(@TokenToAdminUser UserInfoEntity userInfoEntity,GoodsVo goodsVo){
        System.out.println(goodsVo.getPost()+1);
        goodsService.addpost(goodsVo.getPost()+1,String.valueOf(goodsVo.getId()));
        return ResultHandle.getSuccessResult("OK");
    }
}
