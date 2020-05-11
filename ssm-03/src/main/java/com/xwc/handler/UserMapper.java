package com.xwc.handler;

import com.xwc.entity.User;
import com.xwc.entity.UserList;
import com.xwc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-14 20:46
 * @name UserMapper
 * @description
 */
@Controller
public class UserMapper {

    @Autowired
    private IUserService userServiceImpl;

    @RequestMapping("/find")
    public String findUser(User user, Model model, Date time) {
        System.out.println(time);
        List<User> list = userServiceImpl.findUsersBySth(user);
        model.addAttribute("user",list);
        return "/show.jsp";
    }

    @RequestMapping("/edit")
    public String editUser(String []ids ,Model model) {
        List<User> list = userServiceImpl.findUsersByIds(ids);
        model.addAttribute("user",list);
        return "/edit.jsp";
    }

    @RequestMapping("/update")
    /**
     * 无法直接设置包装类类型的集合
     */
    public String update(UserList userList) {
        int result = userServiceImpl.updateUsers(userList.getUserList());
        return "redirect:/show.jsp";
    }
}
