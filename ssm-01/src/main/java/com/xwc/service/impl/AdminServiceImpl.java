package com.xwc.service.impl;

import com.xwc.entity.Admin;
import com.xwc.mapper.AdminMapper;
import com.xwc.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-10 17:46
 * @name AdminServiceImpl
 * @description 管理员业务层实现类
 */

//通过扫描加载成javabean对象
@Service
public class AdminServiceImpl implements IAdminService {

    //扫描自动装配 属性
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    @Override
    public int delete(int admin_id) {
        return adminMapper.delete(admin_id);
    }

    @Override
    public int insert(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public int update(Admin admin) {
        return adminMapper.update(admin);
    }
}
