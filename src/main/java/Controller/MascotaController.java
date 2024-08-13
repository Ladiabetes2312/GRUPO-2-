/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.RespaldoM;
import Dao.MascotasDao;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author josel
 */
public class MascotaController extends HttpServlet {

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

        try {
            // Capturar los datos del formulario
            String nombres = request.getParameter("txtNombre");
            String f_nacimiento = request.getParameter("txtF_Nacimiento");
            int cliente = Integer.parseInt(request.getParameter("txtCli"));
            int raza = Integer.parseInt(request.getParameter("txtRaza"));
            int sexo = Integer.parseInt(request.getParameter("txtSexo"));
            int tipo = Integer.parseInt(request.getParameter("txtTipo"));

            String mensaje = "";
            int res = 0;

            try {
                // Convertir la fecha de nacimiento a LocalDate
                LocalDate fechaNacimiento = LocalDate.parse(f_nacimiento);

                // Crear una instancia de RespaldoM con los datos capturados
                RespaldoM mascota = new RespaldoM();
                mascota.setNombre(nombres);
                mascota.setF_Nacimiento(fechaNacimiento);
                mascota.setClientes_idClientes(cliente);
                mascota.setIdRaza(raza);
                mascota.setIdSexo(sexo);
                mascota.setidTipo_De_Animal(tipo);

                // Instanciar el DAO
                MascotasDao dao = new MascotasDao();

                // Verificar qué botón se presionó
                if (request.getParameter("btnGuardar") != null) {
                    res = dao.insertarMascota(mascota);
                    if (res != 0) {
                        mensaje = "Registro Agregado";
                    }
                } 

                // Establecer el mensaje en la solicitud y redirigir a la página JSP
                request.setAttribute("message", mensaje);
                request.getRequestDispatcher("/Mascotas.jsp").forward(request, response);

            } catch (DateTimeParseException e) {
                mensaje = "Formato de fecha incorrecto";
                request.setAttribute("message", mensaje);
                request.getRequestDispatcher("/Mascotas.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println("Error servlet: " + e.getLocalizedMessage());
            request.setAttribute("message", "Error : " + e.getLocalizedMessage());
            request.getRequestDispatcher("/Mascotas.jsp").forward(request, response);
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
            () {
        return "Short description";
        }// </editor-fold>

    }
