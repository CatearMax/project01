package com.xwc.service.impl;

import com.xwc.entity.Admin;
import com.xwc.mapper.AdminMapper;
import com.xwc.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xwc
 * @create 2020-04-16 11:32
 * @name AdminServiceImpl
 * @description
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }
}
