/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.CitaDao;
import Model.Cita;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author josel
 */
public class CitaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String hora = request.getParameter("txtHora");
            int cliente = Integer.parseInt(request.getParameter("txtCliente"));
            int mascota = Integer.parseInt(request.getParameter("txtMascota"));
            int veterinario = Integer.parseInt(request.getParameter("txtVet"));
            int estado = Integer.parseInt(request.getParameter("txtEstado"));
            String motivo = request.getParameter("txtMotivo");
            String mensaje = "";
            int res;

            Cita cita = new Cita(0, hora, cliente, mascota, veterinario, estado, motivo);
            CitaDao citaDao = new CitaDao();

            if (request.getParameter("btnAgendar") != null) {

                res = citaDao.programarCita(cita);
                if (res != 0) {
                    mensaje = "Cita Programada";

                }

            }
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/Citas.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println("Error al programar la cita" + e.getLocalizedMessage());
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
