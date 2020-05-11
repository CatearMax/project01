package com.xwc.service.impl;

import com.xwc.entity.User;
import com.xwc.mapper.UserMapper;
import com.xwc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xwc
 * @create 2020-05-06 21:15
 * @name UserServiceImpl
 * @description
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer userReg(User user) {
        return userMapper.userReg(user);
    }

    @Override
    public User userLogin(User user) {
        return userMapper.userLogin(user);
    }
}
