package com.xwc.handler;

import com.xwc.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author shkstart
 * @create 2020-04-11 20:52
 * @name AdminHandler
 * @description
 */

//窄化请求映射   让该类中所有的请求url中加上这个配置的路径
@RequestMapping("/adminTest")
//注解 扫描加载成javabean对象
@Controller
public class AdminHandlerTest {

    //注解配置
    //实际访问路径是 /admin/showA.action
    //该访问url 允许post和get请求访问 若不写则是默认允许post和get请求访问
    @RequestMapping(value = "showA",method = {RequestMethod.GET,RequestMethod.POST})
    public void showA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("admin访问");
        //转发路径需要写成绝对路径 在相对路径下会带上"/admin"
        request.getRequestDispatcher("/show.jsp").forward(request,response);
    }

    /**
     * 包装类参数绑定
     * @param admin 包装类 传入的参数为包装类的属性 springmvc会自动到包装类找到对应的属性
     * @param model
     * @return
     */
    @RequestMapping(value = "showB")
    public String showB(Admin admin, Model model) {
        System.out.println("admin_name"+admin.getAdmin_name());
        System.out.println("admin_pwd"+admin.getAdmin_pwd());
        return "/show.jsp";
    }

    /**
     * 简单参数绑定
     * @param model
     * @param admin_name
     * @param admin_id
     * @return
     */
    @RequestMapping(value = "showC")
    public String showC(Model model,String admin_name,Integer admin_id) {
        System.out.println("admin_name"+admin_name);
        return "/show.jsp";
    }

    /**
     * 简单参数绑定 RequestParam注解
     * value = "adminName" String admin_name 访问链接中的参数规定为"adminName"  但是在方法中使用则是使用admin_name
     * required = true 设置为必须属性 若没有则会报错
     * defaultValue = "默认管理员姓名" 默认值
     * @param model
     * @param admin_name
     * @return
     */
    @RequestMapping("/showD")
    public String showD(Model model,
                        @RequestParam(value = "adminName",required = true,defaultValue = "默认管理员姓名")
                                String admin_name ,String admin_pwd) {
        System.out.println("admin_name" + admin_name);
        System.out.println("admin_pwd" + admin_pwd);
        return "/show.jsp";
    }

    @RequestMapping("/showE")
    public String showE(Model model,String admin_name) {
        System.out.println("admin_name:"+admin_name);
        return "/show.jsp";
    }

    /**
     *
     * @param model
     * @param regTime 自动进行解析 将前端传入的String类型转换成date类型
     * @return
     */
    @RequestMapping("/showF")
    public String showF(Model model,Date regTime) {
        System.out.println("注册时间："+regTime);
        return "/show.jsp";
    }
}
