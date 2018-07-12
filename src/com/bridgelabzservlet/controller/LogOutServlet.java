package com.bridgelabzservlet.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  Servlet implementation class LogOutServlet
 * @author Sameer Saurabh
 * @version : 1.0
 * @since : 29/06/2018
 */
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		ServletContext ctx=getServletContext();
		if(session !=null) {
			session.invalidate();
		}
		request.getRequestDispatcher("logoutsuccess.jsp").include(request, response);
		
	}
	 
}
