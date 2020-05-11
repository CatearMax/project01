package com.xwc.mapper;

import com.xwc.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-14 20:23
 * @name UserMapper
 * @description
 */
public interface UserMapper {

    //查询所有用户
    @Select("select * from user")
    public List<User> findAllUser();

    //根据条件查询用户
    public List<User> findUsersBySth(User user);

    //根据id查询用户
    public List<User> findUsersByIds(String [] ids);

    //根据用户信息修改信息
    public int updateUsers(List<User> userList);

}
