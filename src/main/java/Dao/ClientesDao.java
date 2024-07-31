/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.Conexion;
import Model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JOSUEDAVID
 */
public class ClientesDao extends Conexion {

    private Conexion c;

    public ClientesDao(Conexion conexion) {
        this.c = conexion;
    }
    
    public ClientesDao() {
        
    }

    public ArrayList<Clientes> mostrarClientes() {
        ArrayList<Clientes> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM mydb.clientes";
            try (PreparedStatement pre = this.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()) {

                while (rs.next()) {
                    Clientes cli = new Clientes();
                    cli.setIdClientes(rs.getInt(1));
                    cli.setNombres_Apellidos(rs.getString(2));
                    cli.setTelefono(rs.getString(3));
                    cli.setCorreo_Electronico(rs.getString(4));
                    cli.setDireccion(rs.getString(5));
                    cli.setDNI(rs.getString(6));
                    lista.add(cli);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int insertarCliente(Clientes cli) {

        int res = 0;

        try {
            this.conectar();
            String sql = "INSERT INTO mydb.clientes (Nombres_Apellidos, Telefono, Correo_Electronico, Direccion, DNI) VALUES (?,?,?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, cli.getNombres_Apellidos());
            pre.setString(2, cli.getTelefono());
            pre.setString(3, cli.getCorreo_Electronico());
            pre.setString(4, cli.getDireccion());
            pre.setString(5, cli.getDNI());

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar" + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;

    }
}
