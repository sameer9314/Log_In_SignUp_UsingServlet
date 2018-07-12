package com.bridgelabzservlet.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.bridgelabzservlet.dao.JdbcImpl;

/**
 * Application Lifecycle Listener implementation class LogInListener
 *
 */
@WebListener
public class MyListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	
    public MyListener() {
        // TODO Auto-generated constructor stub
    }
    ServletContext ctx;
    static int total=0,current=0;
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent e)  { 
    	
    	total++;
    	current++;
    	
        ctx=e.getSession().getServletContext();
    	ctx.setAttribute("totalusers", total);
    	ctx.setAttribute("currentusers", current);
    	 
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	current--;
    	ctx.setAttribute("currentusers", current);
    	System.out.println("total users : "+ctx.getAttribute("totalusers"));
        System.out.println("total current users : "+ctx.getAttribute("currentusers"));
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
//    public void contextDestroyed(ServletContextEvent event)  { 
//         // TODO Auto-generated method stub
//    }
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
//    public void contextInitialized(ServletContextEvent event)  { 
//         // TODO Auto-generated method stub
//    	JdbcImpl obj=new JdbcImpl();
//    	ctx=event.getServletContext();
//    	ctx.setAttribute("con",obj);
//    }
	
}
