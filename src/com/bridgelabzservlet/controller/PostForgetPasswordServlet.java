package com.bridgelabzservlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabzservlet.dao.JdbcImpl;

/**
 * Servlet implementation class PostForgetPasswordServlet
 */
@WebServlet("/PostForgetPasswordServlet")
public class PostForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		System.out.println("Entered email is : "+email);
		JdbcImpl jdbcObj=new JdbcImpl();
		if(jdbcObj.emailChecker(email)==true) {
			
			MailSender.sendMail(email,jdbcObj.returnPassword(email));
			response.sendRedirect("login");
		}
		else {
			response.sendRedirect("password-recover");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
