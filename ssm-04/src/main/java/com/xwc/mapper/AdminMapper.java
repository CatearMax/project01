package com.xwc.mapper;

import com.xwc.entity.Admin;
import org.apache.ibatis.annotations.Insert;

/**
 * @author xwc
 * @create 2020-04-16 11:34
 * @name AdminMapper
 * @description 管理员代理类
 */
public interface AdminMapper {

    @Insert("insert into admin (admin_name,admin_pwd) values(#{admin_name},#{admin_pwd})")
    public int insertAdmin(Admin amdin);

}
