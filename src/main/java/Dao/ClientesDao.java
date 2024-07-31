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
import java.util.List;

/**
 *
 * @author JOSUEDAVID
 */
public class ClientesDao {

    private Conexion c;

    public ClientesDao(Conexion conexion) {
        this.c = conexion;
    }

    public ArrayList<Clientes> mostrarClientes() {
        ArrayList<Clientes> lista = new ArrayList<>();
        try {
            this.c.conectar();
            String sql = "SELECT * FROM mydb.clientes";
            try (PreparedStatement pre = this.c.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()) {

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
            this.c.desconectar();
        }
        return lista;
    }
}

