<%-- 
    Document   : u04-logout
    Created on : 30/10/2020, 02:56:24 AM
    Author     : Usuario
--%>

<% HttpSession s= request.getSession(false);
   s.invalidate();
   response.sendRedirect("U04-Login/U04-login.jsp");

   
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
