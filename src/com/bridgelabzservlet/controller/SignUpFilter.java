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
 * Servlet Filter implementation class SignUpFilter
 */
@WebFilter("/SignUpFilter")
public class SignUpFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SignUpFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */		// TODO Auto-generated method stub
	// place your code here

	// pass the request along the filter chain
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String user_name = request.getParameter("user_name");
		String email = request.getParameter("email");
		String phoneNumber=request.getParameter("phoneNumber");
		String password = request.getParameter("password");
		
		JdbcImpl obj=new JdbcImpl();
		
		if(obj.updateAccount(user_name, email,phoneNumber, password)==1)
		{
			//request.getRequestDispatcher("Login.html").forward(request,response);
			chain.doFilter(request, response);
		}else
		{
				((HttpServletResponse)response).sendRedirect("resignup");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
