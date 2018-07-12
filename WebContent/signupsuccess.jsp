
<%@page import="java.io.PrintWriter"%>
<%
response.setContentType("text/html");
PrintWriter o=response.getWriter();
o.println("<h3>You Have Successfully Signed Up</h3>");
request.getRequestDispatcher("login.jsp").include(request, response);
 %>