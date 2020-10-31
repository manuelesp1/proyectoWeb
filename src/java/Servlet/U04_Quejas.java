package Servlet;

import Modelo.Persona;
import controlador.PersonaDao;
import java.io.IOException;
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


public class U04_Quejas extends HttpServlet {
    
    private PersonaDao loginDao;

    @Override
    public void init() {
        loginDao = new PersonaDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String direccion= request.getParameter("direccion");
        int edad= Integer.parseInt(request.getParameter("edad"));
        String mensaje= request.getParameter("mensaje");
        PersonaDao loginBean= new PersonaDao();
        loginBean.setEmail(fullname);
        loginBean.setContraseña(email);
        loginBean.setFullname(direccion);
        loginBean.setEdad(edad);
        loginBean.setMensaje(mensaje);
        
        try {
            if (loginDao.consulta(fullname, email, direccion, edad, mensaje)) {
                response.sendRedirect("U04-Inicio/U04-AtencioAlCliente.jsp");
            } else {
                response.sendRedirect("U04-Inicio/U04-index.jsp");
            }
        } catch (IOException e) {
            System.out.println("error"+e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(U04_Quejas.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
}
