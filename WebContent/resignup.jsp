<%@page import="java.io.PrintWriter"%>
<%
response.setContentType("text/html");
PrintWriter o=response.getWriter();
o.println("<h3>Sign Up Unsuccessfull</h3>");
request.getRequestDispatcher("signup.jsp").include(request, response);
 %>
 
 