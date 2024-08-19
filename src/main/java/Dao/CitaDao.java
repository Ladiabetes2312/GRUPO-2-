/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.Conexion;

import Model.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author josel
 */
public class CitaDao extends Conexion {

    public CitaDao() {
    }

    public ArrayList<Cita> listarCitas() {
        ArrayList<Cita> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = " SELECT citas.idCitas, citas.Hora_Cita, mas.NombreM, es.Estado_Cita, citas.Motivo FROM mydb.citas citas \n"
                    + "INNER JOIN mydb.mascotas mas ON citas.Mascotas_idMascotas = mas.idMascotas\n"
                    + "INNER JOIN mydb.clientes cli ON citas.M_idClientes = cli.idClientes\n"
                    + "INNER JOIN  mydb.estado_cita es ON citas.idEstado = es.idEstado_Cita;";
            try (PreparedStatement pre = this.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()) {

                while (rs.next()) {
                    Cita cita = new Cita();

                    cita.setIdCita(rs.getInt(1));
                    cita.setHora_Cita(rs.getString(2));
                    cita.setNombreM(rs.getString(3));
                    cita.setEstado_Cita(rs.getString(4));
                    cita.setMotivo(rs.getString(5));
                    lista.add(cita);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int programarCita(Cita cita) {

        int res = 0;

        try {
            this.conectar();
            String sql = "INSERT INTO citas (Hora_Cita, Mascotas_idMascotas, M_idClientes, idUser, idEstado, Motivo) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pre = this.getCon().prepareStatement(sql);

            pre.setString(1, cita.getHora_Cita());
            pre.setInt(2, cita.getMascotas_idMascotas());
            pre.setInt(3, cita.getM_idClientes());
            pre.setInt(4, cita.getIdUser());
            pre.setInt(5, cita.getIdEstado());
            pre.setString(6, cita.getMotivo());

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar una nueva cita" + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;

    }

    public int eliminarCita(int idCitas) {

        int res = 0;

        try {
            this.conectar();
            String sql = "DELETE FROM citas WHERE idCitas = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, idCitas);
            res = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la cita" + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;

    }

    public int cambiarEstado(Cita cita) {

        int res = 0;

        try {
            this.conectar();

            String sql = "UPDATE mydb.citas SET Hora_Cita=?,idEstado=?, Motivo=? WHERE idCitas=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            
            pre.setString(1, cita.getHora_Cita());
            pre.setInt(2, cita.getIdEstado());
            pre.setString(3, cita.getMotivo());
            pre.setInt(4, cita.getIdCita());
            
            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al cambiar estado" + e.getMessage());
        } finally{
            this.desconectar();
        }
        return res;

    }
    
    
}
