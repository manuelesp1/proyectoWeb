package Servlet;

import Modelo.Persona;
import controlador.PersonaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * @email Ramesh Fadatare
 */


public class LoginServlet extends HttpServlet {
    
    private PersonaDao loginDao;

    @Override
    public void init() {
        loginDao = new PersonaDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession sesion= request.getSession(false);
        PrintWriter out= response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        
        PersonaDao loginBean= new PersonaDao();
        loginBean.setEmail(usuario);
        loginBean.setContraseña(contraseña);
        
  
        try {
            
            switch (loginDao.validate(usuario, contraseña)) {
                case 1:
                    sesion.setAttribute("usuario", usuario);
                    sesion.setAttribute("contraseña", contraseña);                   
                    sesion.setAttribute("rol_id", "1");
                    response.sendRedirect("Vistas/U04-index.jsp");
                    break;
                    
                case 2:
                    
                    sesion.setAttribute("usuario", usuario);
                    sesion.setAttribute("contraseña", contraseña);
                    sesion.setAttribute("rol_id", "2");
                    response.sendRedirect("Vistas/admin.jsp");
                    break;
                    
                case 3:
                    sesion.setAttribute("usuario", usuario);
                    sesion.setAttribute("contraseña", contraseña);
                    sesion.setAttribute("rol_id", "3");
                    response.sendRedirect("Vistas/gerente.jsp");
                    break;
                default:
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Email o contraseña incorrecta');");
                    out.println("location='Vistas/U04-login.jsp';");
                    out.println("</script>");
                    
            }
        } catch (NumberFormatException e) {
            System.out.println("hubo un error "+e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
                   
        }
        
        
    

