package controlador;

import Conexion.conexion;
import Modelo.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class PersonaDao extends Persona{

    public int validate(String usuario, String contraseña ) throws ClassNotFoundException {
       int rol_id=0;
        
        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/llamabus?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select rol_id from cuentas where usuario = ? and contraseña = ? ")) {
            
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contraseña);
            

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                rol_id=rs.getInt(1);
            }
            connection.close();
            

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return rol_id;
        
        
    }
  
    
    
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    public int regitrar(int rol_id, String usuario, String contraseña, String email) throws ClassNotFoundException{

        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection y = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/llamabus?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement x = y
            .prepareStatement("insert into cuentas(rol_id, usuario, contraseña, email) values(?,?,?,?)")) {
            x.setInt(1, rol_id);
            x.setString(2, usuario);
            x.setString(3, contraseña);
            x.setString(4, email);
            
            if (x.executeUpdate()==1) {
                return 1;
            }
  
            
        }catch(Exception e){
                    System.out.println("error"+e);  
           }
        return 0;
         
        }

    public boolean consulta(String fullname, String email, String direccion, int edad, String mensaje) throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection y = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/bssamir?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement x = y
            .prepareStatement("insert into consulta(fullname, email, direccion, edad, mensaje) values(?,?,?,?,?)")) {
            x.setString(1, fullname);
            x.setString(2, email);
            x.setString(3, direccion);
            x.setInt(4, edad);
            x.setString(5, mensaje);
            
            if (x.executeUpdate()==1) {
                return true;
            }
            
            
            
        }catch(Exception e){
            System.out.println("error"+e);
        }
        return false;
    }
    
    
   
    
}
