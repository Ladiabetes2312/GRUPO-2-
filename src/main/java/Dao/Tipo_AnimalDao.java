/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Dao;
 
import Conexion.Conexion;
import Model.Tipo_Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
 
/**
*
* @author JOSUEDAVID
*/
public class Tipo_AnimalDao {
    private Conexion c;
 
    public Tipo_AnimalDao(Conexion conexion) {
        this.c = conexion;
    }
    public ArrayList<Tipo_Animal> mostrarTipo_Animal(){
        ArrayList<Tipo_Animal> lista = new ArrayList<>();
        try {
            this.c.conectar();
            String sql = "SELECT * FROM mybd.tipo_de_animal;";
            try (PreparedStatement pre = this.c.getCon().prepareStatement(sql);ResultSet rs = pre.executeQuery()){
                while (rs.next()){
                    Tipo_Animal ta = new Tipo_Animal();
                    ta.setIdTipo_De_Animal(rs.getInt(1));
                    ta.setDescripcion(rs.getString(2));
                    lista.add(ta);
                }
            }
        } catch (Exception e) {
            System.out.println("error al mostrar " + e.getMessage());
        } finally {
            this.c.desconectar();
        }
        return lista;
    }
}