package com.xwc.service.impl;

import com.xwc.entity.Admin;
import com.xwc.mapper.AdminMapper;
import com.xwc.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2020-04-12 15:00
 * @name AdminServiceImpl
 * @description
 */

//扫描 加载成javabean对象
@Service
public class AdminServiceImpl implements IAdminService {

    //自动装配
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }
}
