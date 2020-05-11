package com.xwc.Servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xwc
 * @create 2020-04-25 20:39
 * @name ServletA
 * @description 通过实现servlet接口来实现
 */
public class ServletA implements Servlet {

    public ServletA() {
        System.out.println("我来构造实现");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我来初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("进入service 开始业务处理");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("摧毁");
    }
}