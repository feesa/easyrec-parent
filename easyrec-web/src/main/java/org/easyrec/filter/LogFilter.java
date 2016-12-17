package org.easyrec.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	// FilterConfig可用于访问Filter的配置信息
	private FilterConfig config;

	// 实现初始化方法
	@Override
	public void init(FilterConfig config) {
		this.config = config;
	}

	// 实现销毁方法
	@Override
	public void destroy() {
		this.config = null;
	}

	// 执行过滤的核心方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ---------下面代码用于对用户请求执行预处理---------
		// 获取ServletContext对象，用于记录日志
		ServletContext context = this.config.getServletContext();
		// 将请求转换成HttpServletRequest请求
		HttpServletRequest hrequest = (HttpServletRequest) request;
		// 记录日志
		context.log("Filter已经截获到用户的请求地址： " + hrequest.getServletPath());
		// Filter只是链式处理，请求依然放行到目的地址
		chain.doFilter(request, response);
		// 再次记录日志
		context.log("请求被定位到" + hrequest.getRequestURI());
	}
}
