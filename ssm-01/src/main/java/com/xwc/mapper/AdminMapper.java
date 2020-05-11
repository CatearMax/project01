package com.xwc.mapper;

import com.xwc.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-10 17:49
 * @name UserMapper
 * @description 改接口会自动扫描加载实现成javabean对象 不需要注解
 */

public interface AdminMapper {

    @Select("select * from admin")
    public List<Admin> findAll();

    @Delete("delete from admin where admin_id = #{value}")
    public int delete(int admin_id);

    @Insert("insert into admin (admin_name,admin_pwd) " +
            " values (#{admin_name},#{admin_pwd})")
    public int insert(Admin admin);

    @Update("update admin set admin_name = #{admin_name}, " +
            "admin_pwd = #{admin_pwd} where admin_id = #{admin_id}")
    public int update(Admin admin);
}
