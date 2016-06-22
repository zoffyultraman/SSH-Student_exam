package com.ite.smvcDemo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ite.smvcDemo.common.page.SystemContext;


public class PagerFilter implements Filter {

	private int pageSize;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		int offset = 0 ;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (NumberFormatException e) {
		}
		
		try {
			SystemContext.setOffset(offset);
			SystemContext.setPageSize(pageSize);
			chain.doFilter(request, response);
		} finally {
			SystemContext.removeOffset();
			SystemContext.removePageSize();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			pageSize = Integer.parseInt(filterConfig.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			pageSize = 5;
		}
	}
}
