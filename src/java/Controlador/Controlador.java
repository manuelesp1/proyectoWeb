/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.U01pasajero;
import ModeloDao.U01pasajeroDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
public class Controlador extends HttpServlet {

    //-------pasajero------------
    String guardar_pasajero = "Vistas/u01-compraPasajes";
    U01pasajero pasajero = new U01pasajero();
    U01pasajeroDao pasajeroDao = new U01pasajeroDao();
    
    //----------rutas------------
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        
        if(accion.equalsIgnoreCase("Agregar")){
            String tipo_doc = request.getParameter("tipo");
            String numdoc = request.getParameter("numdoc");
            String nombre = request.getParameter("nombre");
            String apepat = request.getParameter("apepat");
            String apemat = request.getParameter("apemat");
            String edad = request.getParameter("edad");
            String sexo = request.getParameter("sexo");
            String telef = request.getParameter("telef");
            //String correo = request.getParameter("correo");
            String itinerario_id = request.getParameter("itinerario_id");
            String nom_asiento = request.getParameter("nom_asiento");
            String usuario_id = request.getParameter("usuario_id");
            
            System.out.println("tipodoc: "+tipo_doc);
            System.out.println("numdoc: "+numdoc);
            System.out.println("nombre: "+nombre);
            System.out.println("apepat: "+apepat);
            System.out.println("apemat: "+apemat);
            System.out.println("edad: "+edad);
            System.out.println("sexo: "+sexo);
            System.out.println("telef: "+telef);
            System.out.println("itinerario: "+itinerario_id);
            System.out.println("nom_asiento: "+nom_asiento);
            System.out.println("usuarioid: "+usuario_id);
            
            pasajero.setTipo_doc(tipo_doc);
            pasajero.setNumdoc(numdoc);
            pasajero.setNombre(nombre);
            pasajero.setApepat(apepat);
            pasajero.setApemat(apemat);
            pasajero.setEdad(edad);
            pasajero.setSexo(sexo);
            pasajero.setTelef(telef);
            //pasajero.setCorreo(correo);
            pasajero.setItinerario_id(itinerario_id);
            pasajero.setNom_asiento(nom_asiento);
            pasajero.setUsuario_id(usuario_id);
            pasajeroDao.guardar(pasajero);
            acceso = guardar_pasajero;
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
