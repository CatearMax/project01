package com.xwc.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xwc
 * @create 2020-04-25 20:41
 * @name ${NAME}
 * @description
 */
public class ServletB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//得到servletConfig对象
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig.getServletName());
        System.out.println(servletConfig.getServletContext());
        System.out.println(servletConfig.getInitParameter("Myname"));

        //得到ServletContext 上下文对象
        ServletContext servletContext = getServletConfig().getServletContext();
        //1.获取配置中的上下文参数
        System.out.println(servletContext.getInitParameter("pwd"));
        //2.获取上下文路径
        System.out.println(servletContext.getContextPath());
        //3.获取在服务器硬盘上的绝对路径
        System.out.println(servletContext.getRealPath("/WEB-INF"));*/

      /*  System.out.println("返回客户端发出请求时的完整URL。" + request.getRequestURL());
        System.out.println("返回请求行中的参数部分" + request.getRequestURI());
        System.out.println("返回发出请求的客户机的IP地址" + request.getQueryString());
        System.out.println("客户机的完整主机名" + request.getRemoteHost());
        System.out.println("返回WEB服务器的主机名" + request.getLocalName());
        System.out.println("客户机的ip地址" + request.getRemoteAddr());
        System.out.println("返回WEB服务器的IP地址" + request.getLocalAddr());*/

    }
}
