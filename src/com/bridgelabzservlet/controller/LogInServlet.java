package com.bridgelabzservlet.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabzservlet.dao.JdbcImpl;
import com.bridgelabzservlet.dto.UserBean;

/**
 * Purpose : To validate user log in details.
 * @author Sameer Saurabh
 * @version : 1.0
 * @since : 29/06/2018
 */
public class LogInServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		//PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		JdbcImpl obj=new JdbcImpl();
		ServletContext ctx=getServletContext();
//		JdbcImpl obj=(JdbcImpl)ctx.getAttribute("con");
		UserBean user_info=obj.authenticate(email,password);
		System.out.println(user_info instanceof UserBean);
		if(user_info!=null)
		{
			HttpSession session =request.getSession(true);
			session.setMaxInactiveInterval(1*30);
			session.setAttribute("userData", user_info.getUser_name());
				//response.sendRedirect("logInSuccess");
				request.getRequestDispatcher("logInSuccess.jsp").forward(request, response);
		}
		System.out.println("total users : "+ctx.getAttribute("totalusers"));
	    System.out.println("total current users : "+ctx.getAttribute("currentusers"));
		
	}//end of dopost
}//end of class