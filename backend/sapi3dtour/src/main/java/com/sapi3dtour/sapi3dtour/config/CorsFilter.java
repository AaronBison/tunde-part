package com.sapi3dtour.sapi3dtour.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class CorsFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    
	    response.addHeader("Access-Control-Allow-Origin", "*");

	    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	        response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE,PUT");
	        response.setHeader("Access-Control-Max-Age", "3600");
	        response.setHeader("Access-Control-Allow-Headers", "content-type,authorization");
	        response.setStatus(HttpServletResponse.SC_OK);
	    } else {
	        chain.doFilter(req, res);
	    }
	    
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}
	
}