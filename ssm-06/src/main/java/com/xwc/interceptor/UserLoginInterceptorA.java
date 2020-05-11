package com.xwc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xwc
 * @create 2020-04-21 21:57
 * @name UserLoginInterceptor
 * @description 通过实现拦截器接口来实现拦截器效果
 */
public class UserLoginInterceptorA implements HandlerInterceptor {

    /**
     * 拦截前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("A的prehandler拦截");
        //若是登录操作则不拦截
        if(request.getRequestURI().indexOf("/login.action") > 0) {
            return true;
        }
        if(request.getSession().getAttribute("admin_name") != null){
            return true;
        }
        return true;
    }

    /**
     * preHandle方法返回值为true的时候才会执行
     * 且在进入Handler方法之后 ，在返回modelAndView之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("A的postHandler拦截");
    }

    /**
     * 在整个请求完成之后，也就是渲染了视图后执行
     * 该方法主要用于清理资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("A的after拦截");
    }
}
