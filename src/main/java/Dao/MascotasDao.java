/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Dao;
 
import Conexion.Conexion;
import Model.Mascotas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
 
/**
*
* @author JOSUEDAVID
*/
public class MascotasDao {
    private Conexion c;
 
    public MascotasDao(Conexion conexion) {
        this.c = conexion;
    }
    public ArrayList<Mascotas> mostrarMascotas(){
        ArrayList<Mascotas> lista = new ArrayList<>();
        try{
            this.c.conectar();
            String sql = "SELECT * FROM mydb.mascotas"; 
            try (PreparedStatement pre = this.c.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()){
                while (rs.next()) {
                    Mascotas mstas = new Mascotas();
                    mstas.setIdMascotas(rs.getInt(1));
                    mstas.setNombre(rs.getString(2));
                    mstas.setF_Nacimiento(rs.getDate(3).toLocalDate());
                    mstas.setIdClientes(rs.getInt(4));
                    mstas.setIdRaza(rs.getInt(5));
                    mstas.setIdSexo(rs.getInt(6));
                    mstas.setIdTipo_De_Animal(rs.getInt(7));
                    lista.add(mstas);
                }
            }
        }catch (SQLException e) {
            System.out.println("Error al mostrar " + e.getMessage());
        } finally {
            this.c.desconectar();
        }
        return lista;
    }
}

