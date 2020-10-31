<%-- 
    Document   : listar
    Created on : 27/10/2020, 05:55:04 PM
    Author     : V330
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="modeloDao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .user th td{
                border-spacing: 0;
            }
        </style>
    </head>
    <body>
        <div>
            <h1>Usuarios</h1>
            <form name="listausuarios" action="detalle.jsp" target="detalle" method="POST">
                <table border="1" class="user">
                    <thead>
                        <tr>                            
                            <th>ID</th>
                            <th>USUARIO</th>
                            <th>EMAIL</th>
                            <th>AGREGAR</th>
                        </tr>
                    </thead>
                    <%

                        UsuarioDAO dao = new UsuarioDAO();
                        List<Usuario> list = dao.listar();
                        Iterator<Usuario> iter = list.iterator();
                        Usuario per = null;
                        while (iter.hasNext()) {
                            per = iter.next();


                    %>
                    <tbody>
                        <tr>

                            <td><%=per.getId()%></td>
                            <td><%=per.getUsuario()%></td>
                            <td><%=per.getEmail()%></td>
                            <td><input type='submit' name='id' value="Agregar"> </td>                            
                        </tr>
                        <% }%>

                    </tbody>
                </table>
            </form>    

        </div>
    </body>
</html>
