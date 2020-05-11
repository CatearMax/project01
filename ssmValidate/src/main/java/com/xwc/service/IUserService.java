package com.xwc.service;

import com.xwc.entity.User;

/**
 * @author xwc
 * @create 2020-05-06 21:14
 * @name IUserService
 * @description
 */
public interface IUserService {

    public Integer userReg(User user);

    public User userLogin(User user);
}
