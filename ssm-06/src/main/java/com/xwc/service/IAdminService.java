package com.xwc.service;

import com.github.pagehelper.PageInfo;
import com.xwc.entity.Admin;

/**
 * @author xwc
 * @create 2020-04-21 20:35
 * @name IAdminService
 * @description
 */
public interface IAdminService {

    public Admin findAdminByInfo(Admin admin);

    public PageInfo<Admin> findAllAdmin(Integer startPage,Integer pageSize);

}
