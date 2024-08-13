/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.EstadoCita;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author josel
 */
public class EstadoCitaDao extends Conexion {

    private Conexion c;

    public EstadoCitaDao(Conexion conexion) {

        this.c = conexion;
    }

    public EstadoCitaDao() {
    }

    public ArrayList<EstadoCita> listarEstado() {
        
        ArrayList<EstadoCita> lista = new ArrayList<>();
        
        
        try {
            this.conectar();
            String sql = "SELECT * FROM mydb.estado_cita";
            try (PreparedStatement pre = this.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()){
                
                while (rs.next()){
                    
                    EstadoCita estado = new EstadoCita();
                    
                    estado.setIdEstado_Cita(rs.getInt(1));
                    estado.setEstado_Cita(rs.getString(2));
                    lista.add(estado);
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Error al mostrar estados " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;

    }

}
