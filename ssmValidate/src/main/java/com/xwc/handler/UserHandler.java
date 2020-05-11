package com.xwc.handler;

import com.xwc.entity.User;
import com.xwc.entity.UserLogin;
import com.xwc.entity.UserReg;
import com.xwc.service.IUserService;
import com.xwc.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xwc
 * @create 2020-05-07 12:50
 * @name UserHandler
 * @description
 */
@Controller
public class UserHandler {

    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping("/userLogin")
    //对需要校验的对象前加上 @Validated 注解 value表示对应的分组
    //需要校验的对象后面必须紧跟 BindingResult 来绑定错误信息
    public AjaxResult userLogin(@Validated(value = UserLogin.class) User user, BindingResult bindingResult) {
        System.out.println(user);
       //若数据校验出错
        if(bindingResult.hasErrors()) {
            //取得所有错误
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            //存放需要的错诶信息
            Map<String,String> map = new HashMap<String,String>();
            for (FieldError errors :fieldErrors) {
                //将错误信息放入循环遍历到map中 跨域不能放在model中
                //errors.getField() 错误的属性名 errors.getDefaultMessage()错误的属性信息
                map.put(errors.getField()+"Errors",errors.getDefaultMessage());
            }
           //return AjaxResult.failCheck(model);
            return AjaxResult.failCheck(map);
        } else { //若数据校验成功
            User userResult = userService.userLogin(user);
            //登录成功
            if(userResult != null) {
                return AjaxResult.success(userResult);
            } else {//登录失败
                return AjaxResult.fail(user);
            }
        }
    }

    @RequestMapping("/userReg")
    @ResponseBody
    public AjaxResult userReg(@Validated(value = UserReg.class) User user,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //取得错误信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            //创建map来存放错误信息
            Map<String,String> map = new HashMap<String, String>();
            for(FieldError errors:fieldErrors) {
                map.put(errors.getField()+"Errors",errors.getDefaultMessage());
            }
            return AjaxResult.failCheck(map);
        } else {
            Integer result = userService.userReg(user);
            if(result != 0) {
                return AjaxResult.success();
            } else {
                return AjaxResult.fail(user);
            }
        }
    }

}
