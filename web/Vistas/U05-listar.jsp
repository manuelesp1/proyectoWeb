
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Admi"%>
<%@page import="ModeloDao.AdmiDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../U05-Gerencia/U05-estilos.css">
        <title>Listado General</title>
    </head>
    <body>
        <div>
            <h1>Administradores</h1>
            <a href="U05_Controlador_Admi?accion=add">Agregar Nuevo></a>
            <table border="1">
                <thead>
                    
                    <tr>
                        <th>cuenta_id</th>
                        <th>rol_id</th>
                        <th>usuario</th>
                        <th>contraseña</th>
                        <th>email</th>
                        
                        <th>persona_id</th>
                        <th>nombres</th>
                        <th>apellido_paterno</th>
                        <th>apellido_materno</th>
                        <th>sexo</th>
                        <th>telefono</th>
                        <th>edad</th>
                        <th>documento_id</th>
                        <th>cod_documento</th>
                        <th>modificar</th>
                    </tr>
                    
                </thead>
                <%
                AdmiDao dao=new AdmiDao();
                List<Admi> list=dao.listar();
                Iterator<Admi> iter=list.iterator();
                Admi per=null;
                while(iter.hasNext())
                    {
                    per=iter.next();
                %>
                <tbody>
                    <tr>
                        <td><%=per.getCuenta_id() %></td>
                        <td><%=per.getRol_id() %></td>
                        <td><%=per.getUsuario() %></td>
                        <td><%=per.getContraseña() %></td>
                        <td><%=per.getEmail() %></td>
 
                        <td><%=per.getPersona_id() %></td>
                        <td><%=per.getNombres() %></td>
                        <td><%=per.getApellido_paterno() %></td>
                        <td><%=per.getApellido_materno() %></td>
                        <td><%=per.getSexo() %></td>
                        <td><%=per.getTelefono() %></td>
                        <td><%=per.getEdad() %></td>
                        <td><%=per.getDocumento_id() %></td>
                        <td><%=per.getCod_documento() %></td>
                        <td>
                            <a href="U05_Controlador_Admi?accion=editar&cuenta_id=<%=per.getCuenta_id()%>">Editar Cuenta</a>
                            <a href="U05_Controlador_Admi?accion=editar2&cuenta_id=<%=per.getCuenta_id()%>">Editar Informacion personal</a>
                            <a>Remove</a>
                            
                        </td>
                    </tr>
                    <% } %>
                </tbody>
                
            </table>

            
        </div>
    </body>
</html>
