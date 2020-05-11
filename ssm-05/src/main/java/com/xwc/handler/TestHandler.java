package com.xwc.handler;

import com.xwc.utils.MyException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xwc
 * @create 2020-04-18 18:06
 * @name TestHandler
 * @description
 */
@Controller
public class TestHandler {

    static Logger logger = Logger.getLogger(TestHandler.class);

    @RequestMapping("/upload")
    public String upload(Model model, MultipartFile userFile) throws MyException, IOException {
       if(userFile.isEmpty()) {
           logger.info("文件名为空");
           throw new MyException("文件名为空");
       }
        //获取原始文件名
        String name = userFile.getOriginalFilename();
        //对文件名进行截取从/后面一位开始截取子字符串
        String name2 = name.substring(name.lastIndexOf("/")+1);
        //对名字进行更改防止重名
        Long time = System.currentTimeMillis();
        String newName = time+name2;
        //定义需要存储的路径 存储路径每日一个 d:/2020-04-18  d:/2020-04-19
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String day = format.format(new Date());
        String uploadpath = "d:/upload/" + day;

        //判断文件夹是否存在，如果不存在则创建目录
        File dayFile = new File(uploadpath);
        if(!dayFile.exists()){
            dayFile.mkdirs();
        }

        //上传文件到服务器之后的文件名
        String newFileName = uploadpath +"/"+ newName;
        File newFile = new File(newFileName);

        //将文件复制到指定的目录
        userFile.transferTo(newFile);

        return "/index.jsp";
    }

    @RequestMapping("/test")
    public String test() {
        System.out.println("!!!!!!");
        return "index.jsp";
    }
}
