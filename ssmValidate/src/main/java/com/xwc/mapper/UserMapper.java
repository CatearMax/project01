package com.xwc.mapper;

import com.xwc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author xwc
 * @create 2020-05-06 20:57
 * @name UserMapper
 * @description
 */
public interface UserMapper {

    //public Integer userLogin()

    @Insert("insert into user (user_name,user_pwd,user_state) values(#{user_name},#{user_pwd},#{user_state})")
    public Integer userReg(User user);

    @Select("select * from user " +
            "where user_name = #{user_name} and user_pwd = #{user_pwd} ")
    public User userLogin(User user);
}
