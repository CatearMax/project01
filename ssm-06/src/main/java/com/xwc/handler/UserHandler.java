package com.xwc.handler;

import com.github.pagehelper.PageInfo;
import com.xwc.entity.Admin;
import com.xwc.service.IAdminService;
import com.xwc.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xwc
 * @create 2020-04-21 22:03
 * @name UserHandler
 * @description
 */

@Controller
public class UserHandler {

    @Autowired
    private IAdminService adminService;



    // @RequestMapping 设置请求url 并且设置请求json的格式
    @RequestMapping(value = "/login",produces = {"text/html;charset=utf-8"})
    // @ResponseBody 设置响应的对象 表示不是一个页面 而是其他类型的格式
    @ResponseBody
    public Object loginB(Admin admin, HttpServletRequest request) {
        //后台查询
        Admin result = adminService.findAdminByInfo(admin);
        String json = "";
        //对对象进行封装
        if(result != null) {
            request.setAttribute("admin_name",admin.getAdmin_name());
            return "登录成功";
        } else {
            return "账号或者密码错误" ;
        }
    }

    // @RequestMapping 设置请求url 并且设置请求json的格式
    @RequestMapping(value = "/loginA")
    // @ResponseBody 设置响应的对象 表示不是一个页面 而是其他类型的格式
    @ResponseBody
    public AjaxResult login(Admin admin) {
        //后台查询
        Admin result = adminService.findAdminByInfo(admin);
        String json = "";
        //对对象进行封装
        if(result != null) {
            return AjaxResult.success(result);
        } else {
            return AjaxResult.fail();
        }
    }

    @RequestMapping("/adminlogin")
    @ResponseBody
    public Admin test(Admin admin) {
        System.out.println(admin.getAdmin_name());
        System.out.println(admin.getAdmin_pwd());
        Admin adminA = new Admin();
        adminA.setAdmin_name("hhhh");
        adminA.setAdmin_pwd("yyyyy");
        return adminA;
    }

    @RequestMapping("/adminloginB")
    @ResponseBody
    public AjaxResult testB(Admin admin) {
        System.out.println(admin.getAdmin_name());
        System.out.println(admin.getAdmin_pwd());
        Admin adminA = new Admin();
        adminA.setAdmin_name("hhhh");
        adminA.setAdmin_pwd("yyyyy");
        return AjaxResult.success(adminA);
    }

    @RequestMapping("/ggg")
    public String sb() {
        System.out.println("gggg");
        return "/index.jsp";
    }

    @RequestMapping("/aaa")
    public String sbB() {
        System.out.println("gggg");
        return "/index.jsp";
    }

    //@GetMapping
    @GetMapping("restfulA/{admin_id}")
    @ResponseBody
    public AjaxResult restfulA(@PathVariable Integer admin_id) {
        Admin adminRecive = new Admin();
        adminRecive.setAdmin_id(admin_id);
        Admin admin = adminService.findAdminByInfo(adminRecive);
        if(admin != null) {
            return AjaxResult.success(admin);
        } else {
            return AjaxResult.fail();
        }
    }
    
    @RequestMapping("/getPageA")
    @ResponseBody
    public AjaxResult getPageA(Integer startPage, Integer pageSize) {
        PageInfo<Admin> pageInfo = adminService.findAllAdmin(startPage,pageSize);
        if(pageInfo.getList() != null) {
            return AjaxResult.success(pageInfo);
        }
        return AjaxResult.fail();
    }

    @RequestMapping("/getPageB")
    public String getPageB(Model model,Integer startPage, Integer pageSize) {
        PageInfo<Admin> pageInfo = adminService.findAllAdmin(startPage,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "/show.jsp";
    }
}
