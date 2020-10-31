package Controlador;

import Modelo.U02_Persona;
import ModeloDao.U02_PersonaDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class U02_Controlador extends HttpServlet {
String listar="vistas/U02-Viajes2.jsp";
String add="vistas/U02-Viajes3.jsp";
String edit="vistas/U02-Editar.jsp";
String eliminar = "vistas/U02_eliminar.jsp";
U02_Persona p=new U02_Persona();
U02_PersonaDao dao=new U02_PersonaDao();



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

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("listar")) {
            acceso = listar;
            
        }else if (accion.equalsIgnoreCase("add")) {
            acceso = add;

        }else if (accion.equalsIgnoreCase("Agregar")) {
            int ruta = Integer.parseInt(request.getParameter("txtruta"));
            int embarque = Integer.parseInt(request.getParameter("txtEmbarque"));
            String llegada = request.getParameter("txtLlegada");
            double costo = Double.parseDouble(request.getParameter("txtCosto"));
            int duracion = Integer.parseInt(request.getParameter("txtduracion"));
            String descripcion = request.getParameter("txtDescripcion");
            p.setRuta(ruta);
            p.setEmbarque(embarque);
            p.setLlegada(Integer.parseInt(llegada));
            p.setCosto(costo);
            p.setDuracion(duracion);
            p.setDescripcion(descripcion);
            dao.add(p);
            acceso = listar;

        } else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("iden", request.getParameter("ruta_id"));
            acceso = edit;
            
        } else if (accion.equalsIgnoreCase("Actualizar")) {
            String xruta = request.getParameter("txtruta");
            int ruta_id = Integer.parseInt(xruta);
            int embarque = Integer.parseInt(request.getParameter("txtEmbarque"));
            String llegada = request.getParameter("txtLlegada");
            double costo = Double.parseDouble(request.getParameter("txtCosto"));
            int duracion = Integer.parseInt(request.getParameter("txtduracion"));
            String descripcion = request.getParameter("txtDescripcion");
            p.setRuta(ruta_id);
            p.setEmbarque(embarque);
            p.setLlegada(Integer.parseInt(llegada));
            p.setCosto(costo);
            p.setDuracion(duracion);
            p.setDescripcion(descripcion);
            dao.edit(p);
            acceso = listar;
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
