package com.xwc.service.impl;

import com.xwc.entity.User;
import com.xwc.entity.UserDetails;
import com.xwc.mapper.UserMapper;
import com.xwc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-14 20:15
 * @name UserServiceImpl
 * @description
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public List<User> findUsersBySth(User user) {
        //判断非空
        if(user!= null && user.getUser_name() != null && !user.getUser_name().isEmpty() ) {
            user.setUser_name("%"+user.getUser_name()+"%");
        }
        if (user.getUserDetails() != null && user.getUserDetails() != null
                && user.getUserDetails(). getUser_phone() != null && !user.getUserDetails().getUser_phone().isEmpty()) {
            UserDetails userDetails = user.getUserDetails();
            userDetails.setUser_phone("%"+userDetails.getUser_phone()+"%");
        }
        return userMapper.findUsersBySth(user);
    }

    @Override
    public List<User> findUsersByIds(String[] ids) {
        return userMapper.findUsersByIds(ids);
    }

    @Override
    public int updateUsers(List<User> userList) {
        return userMapper.updateUsers(userList);
    }
}
