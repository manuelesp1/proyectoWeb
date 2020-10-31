/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class U04_Logout extends HttpServlet {
 
    //Ya sea que el método sea por GET o POST, cerraremos la sesion.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession(true);
        
        //Cerrar sesion
        if (sesion!=null) {
            sesion.removeAttribute("usuario");
            RequestDispatcher dispatcher= request.getRequestDispatcher("U04-Inicio/U04-index.jsp");
            dispatcher.forward(request, response);
        }
        
        //Redirecciono 
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Cuenta cerrada con exito');");
        out.println("location='U04-Inicio/U04-index.jsp';");
        out.println("</script>");
    }
}
