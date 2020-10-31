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


public class RegisterServlet extends HttpServlet {
    
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
        
        int rol_id= Integer.parseInt(request.getParameter("rol_id"));
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");
        String email= request.getParameter("email");
        PersonaDao loginBean= new PersonaDao();
        loginBean.setRol_id(rol_id);
        loginBean.setEmail(usuario);
        loginBean.setContraseña(contraseña);
        loginBean.setFullname(email);
        
        try {
            switch (loginDao.regitrar(rol_id, usuario, contraseña, email)) {
                case 1:
                    sesion.setAttribute("usuario", usuario);
                    sesion.setAttribute("contraseña", contraseña); 
                    sesion.setAttribute("email", email);    
                    sesion.setAttribute("rol_id", "1");
                    response.sendRedirect("Vistas/U04-index.jsp");
                    break;
                    
                case 2:
                    
                    sesion.setAttribute("usuario", usuario);
                    sesion.setAttribute("contraseña", contraseña);
                    if (usuario.equals("admin")) {
                        sesion.setAttribute("rol_id", "2");
                    }                  
                    response.sendRedirect("Vistas/U04-login.jsp");
                    break;
                    
                case 3:
                    sesion.setAttribute("usuario", usuario);
                    sesion.setAttribute("contraseña", contraseña);
                    if (usuario.equals("gerente")) {
                        sesion.setAttribute("rol_id", "3");
                    }
                    response.sendRedirect("Vistas/U04-login.jsp");
                    break;
                default:
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error al registrarte, intente denuevo');");
                    out.println("location='Vistas/U04-login.jsp';");
                    out.println("</script>");
                    
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

        
    }
}
