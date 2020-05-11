package com.xwc.utils;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author shkstart
 * @create 2020-04-10 20:58
 * @name EncodingFilter
 * @description
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
       /* response.setContentType("text/json");
        if("post".equals(req.getMethod())) {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            chain.doFilter(request, response);
        }else {
            response.setCharacterEncoding("utf-8");
            chain.doFilter(new MyRequest(req), response);
        }*/
        chain.doFilter(new MyRequest(req), response);
    }

    @Override
    public void destroy() {

    }
}


/**
 *  自定义编码包装类
 * @author xiawenchao
 *
 */
class MyRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    static Logger logger = Logger.getLogger(EncodingFilter.class);

    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String value = request.getParameter(name);
        if(value!= null) {
            try {
                value = new String(value.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                logger.error("编码发生错误"+name+"----"+e.getMessage());
            }
        }
        return super.getParameter(name);
    }

}