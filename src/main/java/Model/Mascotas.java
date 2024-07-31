/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Model;
 
import java.time.LocalDate;
 
 
/**
*
* @author JOSUEDAVID
*/
public class Mascotas {
    private int idMascotas;
    private String Nombre;
    private LocalDate F_Nacimiento;
    private int idClientes;
    private int idRaza;
    private int idSexo;
    private int idTipo_De_Animal;
 
    public Mascotas() {
    }
 
    public Mascotas(int idMascotas, String Nombre, LocalDate F_Nacimiento, int idClientes, int idRaza, int idSexo, int idTipo_De_Animal) {
        this.idMascotas = idMascotas;
        this.Nombre = Nombre;
        this.F_Nacimiento = F_Nacimiento;
        this.idClientes = idClientes;
        this.idRaza = idRaza;
        this.idSexo = idSexo;
        this.idTipo_De_Animal = idTipo_De_Animal;
    }
 
    public int getIdMascotas() {
        return idMascotas;
    }
 
    public void setIdMascotas(int idMascotas) {
        this.idMascotas = idMascotas;
    }
 
    public String getNombre() {
        return Nombre;
    }
 
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
 
    public LocalDate getF_Nacimiento() {
        return F_Nacimiento;
    }
 
    public void setF_Nacimiento(LocalDate F_Nacimiento) {
        this.F_Nacimiento = F_Nacimiento;
    }
 
    public int getIdClientes() {
        return idClientes;
    }
 
    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }
 
    public int getIdRaza() {
        return idRaza;
    }
 
    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }
 
    public int getIdSexo() {
        return idSexo;
    }
 
    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }
 
    public int getIdTipo_De_Animal() {
        return idTipo_De_Animal;
    }
 
    public void setIdTipo_De_Animal(int idTipo_De_Animal) {
        this.idTipo_De_Animal = idTipo_De_Animal;
    }
}