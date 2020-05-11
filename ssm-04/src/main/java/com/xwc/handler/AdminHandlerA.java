package com.xwc.handler;

import com.xwc.entity.Admin;
import com.xwc.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xwc
 * @create 2020-04-16 18:43
 * @name AdminHandlerA
 * @description
 */
@Controller
public class AdminHandlerA {

    @Autowired
    private IAdminService adminService;

    @RequestMapping("/regA.action")
    public String regA(Admin admin) {
        if("A".equals(admin.getAdmin_name())) {
            //派发 浏览器内部转发 数据可共享
            return "forward:index.jsp";
        } else {
            return "forward:reg.jsp";
        }
    }

    @RequestMapping("/regB.action")
    //ModelAttribute(value="key值")==request.setAttribute("a",admin);
    public String regB(@ModelAttribute(value = "a") Admin admin) {
        String index = "/reg.jsp";
        if("B".equalsIgnoreCase(admin.getAdmin_name())) {
            int resutlt = adminService.insertAdmin(admin);
            if(resutlt == 1) {
                index =  "/index.jsp";
            }
        }
        return index;
    }

    @RequestMapping("/regC.action")
    public String regC(Model model,Admin admin) {
        if("C".equalsIgnoreCase(admin.getAdmin_name())) {
            return "/index.jsp";
        } else {
            model.addAttribute("adminC",admin);
            return "/reg.jsp";
        }
    }

    //在所有方法请求前 都会先执行改方法 将request中设置属性
    @ModelAttribute("msg")
    public String msg() {
        return "公用显示信息";
    }
}
