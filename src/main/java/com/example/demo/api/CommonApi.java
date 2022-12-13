package com.example.demo.api;

import com.example.demo.service.Impl.CommonServiceImpl;
import com.example.demo.util.Result;
import com.example.demo.util.ResultHandle;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
@CrossOrigin
@RestController
@RequestMapping("/api/common")
@Api(value = "v1", tags = "公用API\n")
public class CommonApi {
    @Autowired
    CommonServiceImpl commonService;
    @PostMapping("/delete")
    public Result delete(){
        File file = new File("C:\\annimallove\\");
        if (file.exists() == true){
            System.out.println("图片存在，可执行删除操作");
            Boolean flag = false;
            flag = file.delete();
            if (flag){
                System.out.println("成功删除图片"+file.getName());
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("图片不存在，终止操作");
        }
        return ResultHandle.getSuccessResult("OK");
    }

    @PostMapping("/upload")
    public Result addcomments(@RequestParam("file") MultipartFile[] files){
        String img_src=commonService.getImgName();
        if(files != null) {
            for(MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                try{
                    File mkdir = new File("C:\\annimallove");
                    mkdir.mkdirs();
                    if(!mkdir.exists()) {
                        mkdir.mkdirs();
                    }
                    //定义输出流，将文件写入硬盘
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
        return new ResultHandle().getSuccessResult(img_src+".jpg");
    }
}
