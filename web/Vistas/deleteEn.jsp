<%-- 
    Document   : delete
    Created on : 26/10/2020, 07:38:12 PM
    Author     : V330
--%>

<%@page import="modelo.Encomienda"%>
<%@page import="modeloDao.EncomiendaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        EncomiendaDao end=new EncomiendaDao();
        int id=Integer.parseInt((String)request.getAttribute("idel"));
        end.delete(id);
        request.getRequestDispatcher("listarEn.jsp").forward(request, response);
        %>
            
    </body>
</html>
