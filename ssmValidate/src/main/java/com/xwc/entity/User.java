package com.xwc.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author shkstart
 * @create 2020-04-14 19:17
 * @name User
 * @description 用户实体类
 */
public class User implements Serializable {

    private Integer user_id;

    @NotNull(message = "用户名不能为空",groups = {UserReg.class, UserLogin.class})
    @NotEmpty(message = "用户名不能为空",groups = {UserReg.class, UserLogin.class})
    @Pattern(regexp = "^.{4,}$",message = "用户名大于4位",groups = {UserReg.class, UserLogin.class})
    private String user_name;

    @NotNull(message = "用户密码不能为空",groups = {UserReg.class, UserLogin.class})
    @NotEmpty(message = "用户密码不能为空",groups = {UserReg.class, UserLogin.class})
    @Pattern(regexp = "^.{4,}$",message = "密码至少四位",groups = {UserReg.class, UserLogin.class})
    private String user_pwd;

    @NotNull(message = "用户状态不能为空",groups = {UserReg.class})
    private Integer user_state;

    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public Integer getUser_state() {
        return user_state;
    }

    public void setUser_state(Integer user_state) {
        this.user_state = user_state;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_state=" + user_state +
                '}';
    }
}
