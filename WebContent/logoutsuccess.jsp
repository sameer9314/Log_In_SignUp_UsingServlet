<%@page import="java.io.PrintWriter"%>
<% 
 response.setContentType("text/html");
	PrintWriter o=response.getWriter();
	o.println("<h3>You Have Successfully Logged Out</h3>");
	request.getRequestDispatcher("home.jsp").include(request, response);%>