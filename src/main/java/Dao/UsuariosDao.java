/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.Conexion;
import Model.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author josel
 */
public class UsuariosDao extends Conexion {

    private Conexion c;

    public UsuariosDao(Conexion conexion) {

        this.c = conexion;
    }

    public UsuariosDao() {
        
    }

    public ArrayList<Login> mostrarUsuario() {
        ArrayList<Login> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM mydb.usuarios;";
            try (PreparedStatement pre = this.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()) {

                while (rs.next()) {
                    Login login = new Login();
                    login.setIdUsuarios(rs.getInt(1));
                    login.setNombres_Apellidos(rs.getString(2));
                    login.setCorreo_Electronico(rs.getString(3));
                    login.setUsuario(rs.getString(4));
                    login.setPassword(rs.getString(5));
                    lista.add(login);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int insertarUsuario(Login user) {

        int res = 0;

        try {
            this.conectar();
            String sql = "INSERT INTO mydb.usuarios(Nombres_Apellidos, Correo_Electronico, Usuario, Password) VALUES(?, ?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, user.getNombres_Apellidos());
            pre.setString(2, user.getCorreo_Electronico());
            pre.setString(3, user.getUsuario());
            pre.setString(4, user.getPassword());
             
            res= pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar" + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;

    }
}
