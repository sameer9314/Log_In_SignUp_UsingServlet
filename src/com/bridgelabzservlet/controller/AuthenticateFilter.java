package com.bridgelabzservlet.controller;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabzservlet.dao.JdbcImpl;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
@WebFilter("/AuthenticateFilter")
public class AuthenticateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticateFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		JdbcImpl obj=new JdbcImpl();
		
		if(obj.emailChecker(email)==false) {
			((HttpServletResponse) response).sendRedirect("signup");
		}
		else
		{
			if(obj.passwordChecker(email,password)==false) {
				((HttpServletResponse) response).sendRedirect("loginUnsuccess");
			}
			else
			{
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
