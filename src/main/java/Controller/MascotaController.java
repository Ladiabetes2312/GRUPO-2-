/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Mascotas;
import Dao.MascotasDao;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 *
 * @author josel
 */
public class MascotaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int id = Integer.parseInt(request.getParameter("txtID"));

            String nombres = request.getParameter("txtNombre");

            String fechaNacimientoStr = request.getParameter("txtF_Nacimiento");

            // Supongamos que el formato de la fecha es "yyyy-MM-dd" (por ejemplo, "2024-08-18")
            LocalDate f_Nacimiento = LocalDate.parse(fechaNacimientoStr);

            int cliente = Integer.parseInt(request.getParameter("txtCli"));

            int raza = Integer.parseInt(request.getParameter("txtRaza"));

            int sexo = Integer.parseInt(request.getParameter("txtSexo"));

            int tipo = Integer.parseInt(request.getParameter("txtTipo"));

            String mensaje = "";
            int res;

            Mascotas ms = new Mascotas(id, nombres, f_Nacimiento, cliente, raza, sexo, tipo);
            MascotasDao mascotasDao = new MascotasDao();

            if (request.getParameter("btnGuardar") != null) {

                res = mascotasDao.insertarMascota(ms);
                if (res != 0) {
                    mensaje = "Registro Agregado";
                }
            } else if (request.getParameter("btnEditar") != null) {
                res = mascotasDao.modificarMascota(ms);
                if (res != 0) {
                    mensaje = "Registro Editado";
                }
            }
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/Mascotas.jsp").forward(request, response);

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
