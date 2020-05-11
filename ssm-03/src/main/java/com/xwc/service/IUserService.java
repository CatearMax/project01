package com.xwc.service;

import com.xwc.entity.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-14 19:14
 * @name IUserService
 * @description
 */
public interface IUserService {

    //查询所有用户
    public List<User> findAllUser();

    //根据条件查询用户
    public List<User> findUsersBySth(User user);

    //根据id查询用户
    public List<User> findUsersByIds(String [] ids);

    //根据用户信息修改信息
    public int updateUsers(List<User> userList);
}
