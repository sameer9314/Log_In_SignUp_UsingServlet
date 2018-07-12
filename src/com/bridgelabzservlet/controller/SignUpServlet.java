package com.bridgelabzservlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabzservlet.dao.JdbcImpl;

/**
 * Servlet implementation class SignUpServlet
 * @author Sameer Saurabh
 * @version : 1.0
 * @since : 29/06/2018
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String user_name = request.getParameter("user_name");
//		String email = request.getParameter("email");
//		String phoneNumber=request.getParameter("phoneNumber");
//		String password = request.getParameter("password");
//		
//		JdbcImpl obj=new JdbcImpl();
//		
//		if(obj.updateAccount(user_name, email,phoneNumber, password)==1)
//		{
//			//request.getRequestDispatcher("Login.html").forward(request,response);
//			response.sendRedirect("signup-successfull");
//		}else
//		{
//					request.getRequestDispatcher("resignup").forward(request, response);
//		}
		request.getRequestDispatcher("signupsuccess.jsp").forward(request, response);
	}
}
