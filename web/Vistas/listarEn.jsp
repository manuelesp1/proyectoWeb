<%-- 
    Document   : listarEn
    Created on : 28/10/2020, 05:00:25 PM
    Author     : V330
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.Encomienda"%>
<%@page import="java.util.List"%>
<%@page import="modeloDao.EncomiendaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            
            <h1>Usuarios</h1>
            <a href="Controlador?accion=addEn">Agregar nueva encomienda</a>
                <table border="1" class="user">
                    <thead>
                        <tr>                            
                            <th>ID</th>
                            <th>Nombre del Emisor</th>
                            <th>Apellido del Emisor</th>
                            <th>Dni del Emisor</th>
                            <th>Nombre del Receptor</th>
                            <th>Apellido del Receptor</th>
                            <th>Dni del Receptor</th>
                            <th>Lugar</th>
                            <th colspan="2" >ESTADO</th>
                        </tr>
                    </thead>
                    <%

                        EncomiendaDao dao = new EncomiendaDao();
                        List<Encomienda> list = dao.listar();
                        Iterator<Encomienda> iter = list.iterator();
                        Encomienda en = null;
                        while (iter.hasNext()) {
                            en = iter.next();


                    %>
                    <tbody>
                        <tr>

                            <td><%=en.getId()%></td>
                            <td><%=en.getEnvia_nom()%></td>
                            <td><%=en.getEnvia_ape()%></td>
                            <td><%=en.getEnvia_dni()%></td>
                            <td><%=en.getRecoge_nom()%></td>
                            <td><%=en.getRecoge_ape()%></td>
                            <td><%=en.getRecoge_dni()%></td>
                            <td><%=en.getLugar_recojo()%></td>
                            <td><a href="Controlador?accion=editar&id=<%=en.getId() %>" >editar</a> </td>
                            <td><a href="Controlador?accion=eliminar&id=<%=en.getId() %>" >Eliminar</a> </td>                            
                        </tr>
                        <% }%>

                    </tbody>
                </table>
                         
        </div>
                       
    </body>
</html>
