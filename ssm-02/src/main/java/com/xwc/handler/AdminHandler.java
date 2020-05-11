package com.xwc.handler;

import com.xwc.entity.Admin;
import com.xwc.service.IAdminService;
import com.xwc.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author shkstart
 * @create 2020-04-12 14:36
 * @name AdminHandler
 * @description
 */

//窄化请求路径
@RequestMapping("/admin")
//扫描自动装配javabean对象
@Controller
public class AdminHandler {

    //自动装配对象
    @Autowired
    private IAdminService adminServiceImpl;

    @RequestMapping("/insert")
    public void insertAdmin(HttpServletResponse response, Admin admin, Date admin_regTime) throws IOException {
        int result = adminServiceImpl.insertAdmin(admin);
        if(result != 0) {
            String json = AjaxResult.success(1);
            System.out.println(json);
            response.getWriter().print(json);
        } else {
            String json = AjaxResult.fail();
            response.getWriter().print(json);
        }
    }
}
