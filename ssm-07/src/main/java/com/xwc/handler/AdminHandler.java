package com.xwc.handler;

import com.xwc.entity.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xwc
 * @create 2020-04-28 17:59
 * @name AdminHandler
 * @description
 */
@Controller
public class AdminHandler {

    @RequestMapping("/login")
    public String login(Admin admin, Model model) {
        //创建认证主体
        Subject currentUser = SecurityUtils.getSubject();

        //通过前台传入的用户名和密码创建口令
        UsernamePasswordToken token =
                new UsernamePasswordToken(admin.getAdmin_name(), admin.getAdmin_pwd());

        try{
            //调用安全管理器中的认证器进行登录操作
            currentUser.login(token);
            //拿到session 设置用户信息
            Session session = currentUser.getSession();
            //取出查询到的用户信息
            Admin adminInfo = (Admin) currentUser.getPrincipal();
            session.setAttribute("admin",adminInfo);
            return "/index.jsp";
        }catch(UnknownAccountException e){
            e.printStackTrace();
            model.addAttribute("error","用户不存在");
            return "/login.jsp";
        }catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            model.addAttribute("error","密码错误");
            return "/login.jsp";
        }catch (LockedAccountException e){
            model.addAttribute("error","账户被锁定");
            return "/login.jsp";
        }catch (AuthenticationException e) {
            return "/login.jsp";
        }
    }

    @RequestMapping("/showUsers")
    public String showUsers() {
        //创建认证主体
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //对当前用户的角色进行检查 前提是必须对登陆成功的用户进行设置了角色
            currentUser.checkRole("超级管理员");
            return "/show.jsp";
        } catch (Exception e) {
            return "/login.jsp";
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut() {
        //创建认证主体
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "/login.jsp";
    }
}
