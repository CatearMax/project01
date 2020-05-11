package com.xwc.handler;

import com.xwc.entity.Admin;
import com.xwc.service.IAdminService;
import com.xwc.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-10 17:50
 * @name AdminHandler
 * @description 处理器 处理不同的请求
 */

//注解扫描成javabean对象
@Controller
public class AdminHandler {

    //自动装配属性 创建service层对象
    @Autowired
    private IAdminService adminServiceImpl;

    @RequestMapping("/findAll.action")
    public ModelAndView showA() {
        ModelAndView modelAndView = new ModelAndView();
        List<Admin> list = adminServiceImpl.findAll();
        modelAndView.addObject("msg",list);
        modelAndView.setViewName("show.jsp");
        return modelAndView;
    }

    @RequestMapping("/findAllAdmin.action")
    public void showB(HttpServletResponse response) throws IOException {
        List<Admin> list = adminServiceImpl.findAll();
        if (list != null) {
            String json =  AjaxResult.success(list);
            response.getWriter().print(json);
        } else {
            String json = AjaxResult.fail();
            response.getWriter().print(json);
        }
    }

    @RequestMapping("/delete.action")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取得参数
        Integer admin_id = Integer.parseInt(request.getParameter("admin_id"));
        int result = adminServiceImpl.delete(admin_id);
            List<Admin> list = adminServiceImpl.findAll();
            //设置属性
            request.setAttribute("msg",list);
            //转发到页面
            request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    @RequestMapping("/update.action")
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取得参数
        Integer admin_id = Integer.parseInt(request.getParameter("admin_id"));
        String amdin_name = request.getParameter("admin_name");
        String admin_pwd = request.getParameter("admin_pwd");
        Admin admin = new Admin(admin_id, amdin_name, admin_pwd);
        //组装对象
        int result = adminServiceImpl.update(admin);
        List<Admin> list = adminServiceImpl.findAll();
        //设置属性
        request.setAttribute("msg",list);
        //转发到页面
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }

    @RequestMapping("/add.action")
    public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取得参数
        String amdin_name = request.getParameter("admin_name");
        String admin_pwd = request.getParameter("admin_pwd");
        Admin admin = new Admin(amdin_name, admin_pwd);
        int result = adminServiceImpl.insert(admin);
        List<Admin> list = adminServiceImpl.findAll();
        //设置属性
        request.setAttribute("msg",list);
        //转发到页面
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}
