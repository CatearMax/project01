package com.xwc.realm;

import com.xwc.entity.Admin;
import com.xwc.mapper.AdminMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xwc
 * @create 2020-04-28 17:52
 * @name MyRealm
 * @description
 */

public class MyRealm extends AuthorizingRealm {

    @Autowired
    AdminMapper adminMapper;
    /**
     * 用于验证用户是否登陆
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        //获取口令中的用户名
        String admin_name = (String) token.getPrincipal();
        //通过数据库链接获取用户信息
        Admin admin = adminMapper.getAdmin(admin_name);
        if(admin != null){
            //设置认证信息 将用户的信息放到认证信息中
            AuthenticationInfo info = new SimpleAuthenticationInfo(admin, admin.getAdmin_pwd(), "myRealm");
            return info;
        }
        return null;
    }

    /**
     * 在登陆成功之后，设置用户的角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        //获取用户名
        Admin admin = (Admin) principals.getPrimaryPrincipal();
        //设置授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo ();
        //设置角色
        info.setRoles(adminMapper.getRoles(admin.getAdmin_id()));
        System.out.println("------?"+adminMapper.getRoles(admin.getAdmin_id()));
        //设置权限
       info.setStringPermissions(adminMapper.getPermission(admin.getAdmin_id()));
        return info;
    }
}
