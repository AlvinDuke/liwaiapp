package top.duyt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import top.duyt.util.SystemContext;


public class PagerParamFilter implements Filter{

	private int pageSize;
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			int pageOffset = 0;
			try {
				pageOffset = Integer
						.parseInt(request.getParameter("pager.offset"));
			} catch (Exception e) {
			}
			SystemContext.setPageOffset(pageOffset);
			SystemContext.setPageSize(pageSize);
			
			
			chain.doFilter(request, response);
		}
		finally{
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
		}
		
	}

	public void init(FilterConfig cfg) throws ServletException {
		try {
			pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
		} catch (Exception e) {
			pageSize = 10;
		}
	}

}
