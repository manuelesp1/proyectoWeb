package Controlador;

import Modelo.Admi;
import ModeloDao.AdmiDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Prueba1 extends HttpServlet {
String listar="vistas/listar.jsp";
String add="vistas/add.jsp";
String edit="vistas/edit.jsp";
Admi p=new Admi();
AdmiDao dao=new AdmiDao();


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
       String acceso="";
       String accion=request.getParameter("accion");
       if (accion.equalsIgnoreCase("listar")){
        acceso=listar;
       }
       else if(accion.equalsIgnoreCase("add")){
       acceso=add;
       } 
       
       else if(accion.equalsIgnoreCase("Agregar")){
       String usuario=request.getParameter("txtUsuario");
       String contraseña=request.getParameter("txtContraseña");
       String email=request.getParameter("txtEmail");
       
       String nombres=request.getParameter("txtNombres");
       String apellido_paterno=request.getParameter("txtApellido_paterno");
       String apellido_materno=request.getParameter("txtApellido_materno");
       String sexo=request.getParameter("txtSexo");
       String telefono=request.getParameter("txtTelefono");
       String edad=request.getParameter("txtEdad");
       String cod_documento=request.getParameter("txtCod_documento");
       
       
       p.setUsuario(usuario);
       p.setContraseña(contraseña);
       p.setEmail(email);
       
       p.setNombres(nombres);
       p.setApellido_paterno(apellido_paterno);
       p.setApellido_materno(apellido_materno);
       p.setSexo(sexo);
       p.setTelefono(telefono);
       p.setEdad(Integer. parseInt (edad));
       p.setCod_documento(cod_documento);
       
       dao.add(p);
       acceso=listar;
       
       } 
       
       else if(accion.equalsIgnoreCase("editar")){
           request.setAttribute("idper", request.getParameter("cuenta_id"));
       acceso=edit;
       }
       
       else if(accion.equalsIgnoreCase("Actualizar")){
       String xcuenta_id=request.getParameter("txtCuenta_id");
       int id=Integer.parseInt(xcuenta_id);
       
       String usuario=request.getParameter("txtUsuario");
       String contraseña=request.getParameter("txtContraseña");
       String email=request.getParameter("txtEmail");
       
       String nombres=request.getParameter("txtNombres");
       String apellido_paterno=request.getParameter("txtApellido_paterno");
       String apellido_materno=request.getParameter("txtApellido_materno");
       String sexo=request.getParameter("txtSexo");
       String telefono=request.getParameter("txtTelefono");
       String edad=request.getParameter("txtEdad");
       String cod_documento=request.getParameter("txtCod_documento");
       
       
       p.setUsuario(usuario);
       p.setContraseña(contraseña);
       p.setEmail(email);
       
       p.setNombres(nombres);
       p.setApellido_paterno(apellido_paterno);
       p.setApellido_materno(apellido_materno);
       p.setSexo(sexo);
       p.setTelefono(telefono);
       p.setEdad(Integer. parseInt (edad));
       p.setCod_documento(cod_documento);
       
      dao.edit(p);
      acceso=listar;
       }
       
       RequestDispatcher vista=request.getRequestDispatcher(acceso);
       vista.forward(request,response);
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
