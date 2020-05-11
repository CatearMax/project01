package com.xwc.service;

import com.xwc.entity.Admin;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-10 17:44
 * @name IAdminService
 * @description 管理员业务层接口
 */
public interface IAdminService {

    public List<Admin> findAll();

    public int delete(int admin_id);

    public int insert(Admin admin);

    public int update(Admin admin);
}
