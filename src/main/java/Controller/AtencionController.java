/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.R_Atencion;
import Dao.R_AtencionDao;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 *
 * @author josel
 */
public class AtencionController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String hora = request.getParameter("txtHora");
            Date fechaVisita = Date.valueOf(request.getParameter("txtFecha"));
            String motivoVisita = request.getParameter("txtMotivos");
            String estadoMascota = request.getParameter("txtEstadoMascota");
            String diagnosticoGenerado = request.getParameter("txtDiagnostico");
            String tratamiento = request.getParameter("txtTratamientos");
            String observaciones = request.getParameter("txtObservaciones");
            int citasIdCitas = Integer.parseInt(request.getParameter("idCita"));
            String mensaje = "";
            int res = 0;

            R_Atencion r_Atencion = new R_Atencion(0, hora, fechaVisita, motivoVisita, estadoMascota, diagnosticoGenerado, tratamiento, observaciones, citasIdCitas);

            R_AtencionDao r_AtencionDao = new R_AtencionDao();

            if (request.getParameter("btnGuardar") != null) {

                res = r_AtencionDao.agregarRegistro(r_Atencion);
                if (res != 0) {
                    mensaje = "Registro Agregado";

                }

            }
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/Registro_de_Atencion.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error en servlet" + e.getLocalizedMessage());
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
        processRequest(request, response);
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
