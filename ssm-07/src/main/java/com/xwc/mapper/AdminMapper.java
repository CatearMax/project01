package com.xwc.mapper;

import com.xwc.entity.Admin;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author xwc
 * @create 2020-04-28 18:09
 * @name AdminMapper
 * @description
 */
public interface AdminMapper {

    /**
     * 根据管理员姓名查询管理员
     * @param admin_name 管理员姓名
     * @return
     */
    @Select("select * from admin where admin_name = #{value}")
    public Admin getAdmin(String admin_name);

    /**
     * 根据id查询角色
     * @param admin_id
     * @return
     */
    @Select("select role_name from tb_roles where admin_id = #{value}")
    public Set<String> getRoles(Integer admin_id);

    /**
     * 根据用户名查询所对应的的权限
     * @param admin_id
     * @return
     */
    @Select("select p.permission_name from permission p,tb_roles r  where r.admin_id = #{value} and r.role_name = p.role_name")
    public Set<String> getPermission(Integer admin_id);
}
