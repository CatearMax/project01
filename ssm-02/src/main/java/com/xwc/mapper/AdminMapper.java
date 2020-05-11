package com.xwc.mapper;

import com.xwc.entity.Admin;
import org.apache.ibatis.annotations.Insert;

/**
 * @author shkstart
 * @create 2020-04-12 14:51
 * @name AdminMapper
 * @description
 */
public interface AdminMapper {

    @Insert("insert into admin (admin_name,admin_pwd,admin_regTime) values(#{admin_name},#{admin_pwd},#{admin_regTime})")
    public int insertAdmin(Admin admin);
}
