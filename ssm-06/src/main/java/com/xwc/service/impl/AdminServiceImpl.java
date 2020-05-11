package com.xwc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwc.entity.Admin;
import com.xwc.mapper.AdminMapper;
import com.xwc.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xwc
 * @create 2020-04-21 21:56
 * @name AdminServiceImpl
 * @description
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByInfo(Admin admin) {
        return adminMapper.findAdminByInfo(admin);
    }

    /**
     * 进行分页查询
     * @param startPage 起始页码
     * @param pageSize  每页数据条数
     * @return
     */
    @Override
    public PageInfo<Admin> findAllAdmin(Integer startPage, Integer pageSize) {

        //对传入参数进行非空判断
        startPage = (startPage == null ? 3:startPage);
        pageSize = (pageSize == null ? 2:pageSize);

        //对参数初始化 对紧随其后第一个sql语句有效
        PageHelper.startPage(startPage,pageSize);
        //进行查询 不会按照mapper层的sql查询
        //会先查询 数据的总行数 count(*)
        //再对进行分页查询  limit startPage,pageSize
        List<Admin> list = adminMapper.findAllAdmin();
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(list);
        return pageInfo;
    }
}
