package com.xwc.entity;

import java.io.Serializable;

/**
 * @author shkstart
 * @create 2020-04-14 20:17
 * @name UserDetails
 * @description
 */
public class UserDetails implements Serializable {

    private Integer ud_id;
    private String user_addr;
    private String user_phone;

    public UserDetails() {
    }

    public Integer getUd_id() {
        return ud_id;
    }

    public void setUd_id(Integer ud_id) {
        this.ud_id = ud_id;
    }

    public String getUser_addr() {
        return user_addr;
    }

    public void setUser_addr(String user_addr) {
        this.user_addr = user_addr;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "ud_id=" + ud_id +
                ", user_addr='" + user_addr + '\'' +
                ", user_phone='" + user_phone + '\'' +
                '}';
    }
}
