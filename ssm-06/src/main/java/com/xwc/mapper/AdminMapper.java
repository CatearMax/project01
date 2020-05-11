package com.xwc.mapper;

import com.xwc.entity.Admin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xwc
 * @create 2020-04-21 20:31
 * @name AdminMapper
 * @description
 */
public interface AdminMapper {

    @Select("select * from admin where admin_name = #{admin_name} and admin_pwd = #{admin_pwd}")
    public Admin findAdminByInfo(Admin admin);

    @Select("select * from admin")
    public List<Admin> findAllAdmin();
}
