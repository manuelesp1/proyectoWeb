<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Config.U02_Conexion"%>
<%
U02_Conexion con=new U02_Conexion();
Connection cn;
cn=con.getConnection();
ResultSet rs=null;
Statement st;
String sql="Select * from rutas";
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div>
            
                <form action="prueba2">
               
                <table border="1" >
                              <tr>
                                  <td>RUTA</td>
                                  <td>EMBARQUE</td>
                                  <td>LLEGADA</td>
                                  <td>COSTO DE LA RUTA</td>
                                  <td>DURACION DEL VIAJE</td>
                                  <td>DESCRIBCION DEL VIAJE</td>
                              </tr>
                              <%
                                  try {
                                      st = cn.createStatement();
                                      rs = st.executeQuery(sql);
                                      while (rs.next()) {
                                          out.println("<td>");
                                          out.println(rs.getInt("ruta_id"));
                                          out.println("</td>");

                                          out.println("<td>");
                                          out.println(rs.getInt("embarque_id"));
                                          out.println("</td>");

                                          out.println("<td>");
                                          out.println(rs.getInt("llegada_id"));
                                          out.println("</td>");

                                          out.println("<td>");
                                          out.println(rs.getDouble("costo_ruta"));
                                          out.println("</td>");

                                          out.println("<td>");
                                          out.println(rs.getInt("duracion"));
                                          out.println("</td>");
                                          
                                          out.println("<td>");
                                          out.println(rs.getString("descripcion"));
                                          out.println("</td>");

                                          out.println("</tr>");
                                      }

                                  } catch (Exception e) {
                                  }
                                  rs.close();
                                  cn.close();
                                  
                                %>
                             
                          </table>
            </form>            
        </div>

    </body>
</html>

