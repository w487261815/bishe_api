package com.example.demo.service.Impl;

import com.example.demo.service.CommonService;
import com.example.demo.util.ResultHandle;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service(value = "CommonServiceImpl")
public class CommonServiceImpl implements CommonService {
    @Override
    public String getImgName() {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd_hhmmssSS");
        return ft.format(dNow);
    }

    @Override
    public String getTime() {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        return ft.format(dNow);
    }

    @Override
    public void deleteImg(String src) {
        File file = new File("C:\\annimallove\\"+src);
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
    }
}
