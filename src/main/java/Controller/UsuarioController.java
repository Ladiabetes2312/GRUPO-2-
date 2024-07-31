/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Login;
import Dao.UsuariosDao;
import java.util.ArrayList;
import com.google.gson.Gson;

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
public class UsuarioController extends HttpServlet {
    private Gson gson = new Gson();
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
        //processRequest(request, response);
        try {
            ArrayList<String> data = new ArrayList<String>();
            PrintWriter out = response.getWriter();
            
            String nombre = request.getParameter("txtNombre");
            String correo = request.getParameter("txtCorreo");
            String usuario = request.getParameter("txtUsuario");
            String password = request.getParameter("txtContrasena");
            String mensaje = "Error";
            int resp;
            Login user = new Login(0, nombre, correo, usuario, password);
            UsuariosDao obj = new UsuariosDao();
            resp = obj.insertarUsuario(user);
            if(resp != 0){
                mensaje = "REGISTRO AGREGADO";
            
            }
            
            data.add(mensaje);
          
            
            String dataJSON = this.gson.toJson(data);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            out.print(dataJSON);
            
        }catch(Exception e){
            System.out.println("Error en Servlet" +e.getLocalizedMessage());
        }
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
