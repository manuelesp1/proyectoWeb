
<%@page import="Modelo.Admi"%>
<%@page import="ModeloDao.AdmiDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificacion de Registros</title>
    </head>
    <body>
       <% 
       AdmiDao dao=new AdmiDao();
       int cuenta_id=Integer.parseInt((String)request.getAttribute("cuenta_idper"));
       Admi p=(Admi)dao.list(cuenta_id);
       %>
       <h1>Modificar Cuenta de Administrador</h1>
       <form action="U05_Controlador_Admi">
           <table border="1">
                    <tbody>
                       
  
                        <tr>
                            <td>Nombres:</td>
                            <td> <input type="text" name="txtNombres" value="<%=p.getNombres()%>" /> </td>
                        </tr>
                        <tr>
                            <td>Apellido Paterno:</td>
                            <td> <input type="text" name="txtApellido_paterno" value="<%=p.getApellido_paterno()%>" /> 
                            <input type="hidden" name="txtCuenta_id" value="<%=p.getCuenta_id()%>" /> </td>
                        </tr>
                        <tr>
                            <td>Apellido Materno:</td>
                            <td> <input type="text" name="txtApellido_materno" value="<%=p.getApellido_materno()%>" /> </td>
                        </tr>
                        <tr>
                            <td>Sexo:</td>
                            <td> <input type="text" name="txtSexo" value="<%=p.getSexo()%>" /> </td>
                        </tr>
                        <tr>
                            <td>Telefono:</td>
                            <td> <input type="text" name="txtTelefono" value="<%=p.getTelefono()%>" /> </td>
                        </tr>
                       <tr>
                            <td>Edad:</td>
                            <td> <input type="text" name="txtEdad" value="<%=p.getEdad()%>" /> </td>
                        </tr>
                        <tr>
                            <td>DNI :</td>
                            <td> <input type="text" name="txtCod_documento" value="<%=p.getCod_documento()%>" /> </td>
                        </tr>
                        <tr>
                            <td colspan="2"> <input type="submit" value="Actualizar2" name="accion" /> </td>
                        </tr>
                        
                    </tbody>
                </table>
                            <a href="U05_Controlador_Admi?accion=listar">Regresar</a>
       </form>
        
    </body>
</html>
