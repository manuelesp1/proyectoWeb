
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.U02_Persona"%>
<%@page import="ModeloDao.U02_PersonaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado General</title>
    </head>
    <body>
        <div>
            <h1>Personas</h1>
            <a href="Controlador?accion=add">Agregar Nuevo></a>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <%
                U02_PersonaDao dao=new U02_PersonaDao();
                List<U02_Persona> list=dao.listar();
                Iterator<U02_Persona> iter=list.iterator();
                U02_Persona per=null;
                while(iter.hasNext())
                    {
                    per=iter.next();
                %>
                <tbody>
                    <tr>
                        <td><%=per.getId() %></td>
                        <td><%=per.getDni() %></td>
                        <td><%=per.getNom() %></td>
                        <td>
                            <a href="Controlador?accion=editar&id=<%=per.getId()%>">Editar</a>
                            <a>Remove</a>
                            
                        </td>
                    </tr>
                    <% } %>
                </tbody>
                
            </table>

            
        </div>
    </body>
</html>
