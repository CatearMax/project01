package com.xwc.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求和响应头过滤
 * @author xiawenchao
 *
 */
@WebFilter("/*")
public class HeadFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resposne, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) resposne;
		//设置跨域
		resp.setHeader("Access-Control-Allow-Origin", "*");
		chain.doFilter(request, resposne);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
