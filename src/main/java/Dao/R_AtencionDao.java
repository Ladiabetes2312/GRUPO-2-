/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conexion.Conexion;
import Model.R_Atencion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author josel
 */
public class R_AtencionDao extends Conexion {

    public R_AtencionDao() {
    }

    public ArrayList<R_Atencion> mostrarRegistros() {
        ArrayList<R_Atencion> lista = new ArrayList<>();

        try {
            this.conectar();
            String sql = "SELECT R.*, M.NombreM\n"
                    + "FROM mydb.registro_de_atencion R\n"
                    + "INNER JOIN citas C ON R.Citas_idCitas = C.idCitas\n"
                    + "INNER JOIN mascotas M ON C.Mascotas_idMascotas = M.idMascotas";

            try (PreparedStatement pre = this.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()) {

                while (rs.next()) {
                    R_Atencion atencion = new R_Atencion();

                    atencion.setIdRegistro(rs.getInt("idRegistro"));
                    atencion.setFechaVisita(rs.getDate("Fecha_Visita"));
                    atencion.setHora(rs.getString("Hora")); 
                    atencion.setMotivoVisita(rs.getString("Motivo_visita"));
                    atencion.setEstadoMascota(rs.getString("Estado_Mascota"));
                    atencion.setDiagnosticoGenerado(rs.getString("Diagnostico_Generado"));
                    atencion.setTratamiento(rs.getString("Tratamiento"));
                    atencion.setObservaciones(rs.getString("Observaciones"));
                    atencion.setCitasIdCitas(rs.getInt("Citas_idCitas"));
                    atencion.setNombreM(rs.getString("NombreM"));

                    lista.add(atencion);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar historias clinicas: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int agregarRegistro(R_Atencion atencion) {

        int res = 0;

        try {
            this.conectar();
            String sql = "INSERT INTO registro_de_atencion (Fecha_Visita, Hora, Motivo_visita, Estado_Mascota, Diagnostico_Generado, Tratamiento, Observaciones, Citas_idCitas)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setDate(1, atencion.getFechaVisita());        
            pre.setString(2, atencion.getHora());
            pre.setString(3, atencion.getMotivoVisita());
            pre.setString(4, atencion.getEstadoMascota());
            pre.setString(5, atencion.getDiagnosticoGenerado());
            pre.setString(6, atencion.getTratamiento());
            pre.setString(7, atencion.getObservaciones());
            pre.setInt(8, atencion.getCitasIdCitas());

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar Registro de atencion : " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;

    }

}
