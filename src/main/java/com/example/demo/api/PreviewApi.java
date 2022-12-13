package com.example.demo.api;

import com.example.demo.api.param.ShowScParam;
import com.example.demo.api.param.ids;
import com.example.demo.config.annotation.TokenToAdminUser;
import com.example.demo.entity.UserInfoEntity;
import com.example.demo.entity.YuceEntity;
import com.example.demo.service.Impl.CommonServiceImpl;
import com.example.demo.service.Impl.PreviewServiceImpl;
import com.example.demo.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/dis")
@Api(value = "v1", tags = "宠物识别相关接口\n")
public class PreviewApi {
    @Autowired
    PreviewServiceImpl previewService;
    @Autowired
    CommonServiceImpl commonService;
    @PostMapping("/upload")
    @ApiOperation(value = "预测")
    public Result addcomments(@TokenToAdminUser UserInfoEntity userInfoEntity, @RequestParam("file") MultipartFile[] files){
        String img_src=userInfoEntity.getUsername();
        if(files != null) {
            for(MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                try{
                    File mkdir = new File("C:\\annimallove");
                    mkdir.mkdirs();
                    if(!mkdir.exists()) {
                        mkdir.mkdirs();
                    }
                    System.out.println(img_src);
                    FileOutputStream os = new FileOutputStream(mkdir.getPath()+"\\"+img_src+".jpg");
                    InputStream in = file.getInputStream();
                    int b = 0;
                    while((b=in.read())!=-1){ //读取文件
                        os.write(b);
                    }
                    os.flush(); //关闭流
                    in.close();
                    os.close();
                }catch(Exception  e) {
                    e.printStackTrace();
                }
            }
        }else {
            return new ResultHandle().getFailResult("文件没找到");
        }

        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
        try {
            // 本地文件路径
            String filePath = "C:\\annimallove\\"+img_src+".jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.73f5511773e9bffb60af9cbb5262ed72.2592000.1671425127.282335-27405269";
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return ResultHandle.getSuccessResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
     }

    @GetMapping("/show")
    @ApiOperation(value = "展示")
    public Result select(@TokenToAdminUser UserInfoEntity userInfoEntity){
        return ResultHandle.getSuccessResult(previewService.show(userInfoEntity.getUid()));
    }
    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public Result add(@TokenToAdminUser UserInfoEntity userInfoEntity){
        List<YuceEntity> yuceEntityList = previewService.show(userInfoEntity.getUid());
        if(yuceEntityList.size()>=4){
            return ResultHandle.getFailResult("收藏夹已上限");
        }
        File mkdir = new File("C:\\annimallove\\"+userInfoEntity.getUsername()+".jpg");
        String img_Src=commonService.getImgName();
        File mkdirs = new File("C:\\annimallove\\"+img_Src+".jpg");
        YuceEntity yuceEntity = new YuceEntity();
        yuceEntity.setIdenty(commonService.getImgName());
        yuceEntity.setImg(img_Src+".jpg");
        yuceEntity.setUserid(userInfoEntity.getUid());
        mkdir.renameTo(mkdirs);
        previewService.add(yuceEntity);
        return ResultHandle.getSuccessResult("OK");
    }
    @PostMapping("/del")
    @ApiOperation(value = "删除")
    public Result del(@TokenToAdminUser UserInfoEntity userInfoEntity,@RequestBody ids ids){
        if (ids.getId()==null){
            return ResultHandle.getFailResult("操作非法");
        }
        System.out.println(ids.getId()+"----------"+userInfoEntity.getUid());
        previewService.del(ids.getId(),userInfoEntity.getUid());
        return ResultHandle.getSuccessResult("OK");
    }
    @GetMapping("/showsc")
    @ApiOperation(value = "展示收藏")
    public Result showsc(@TokenToAdminUser UserInfoEntity userInfoEntity, ShowScParam showScParam){
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/animal";
        try {
            // 本地文件路径
            String filePath = "C:\\annimallove\\"+showScParam.getImg();
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.73f5511773e9bffb60af9cbb5262ed72.2592000.1671425127.282335-27405269";
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return ResultHandle.getSuccessResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultHandle.getFailResult("失败");
    }
}
