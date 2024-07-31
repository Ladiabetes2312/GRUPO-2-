/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
 
/**
*
* @author JOSUEDAVID
*/
public class Clientes {
    private int idClientes;
    private String Nombres_Apellidos;
    private String Telefono;
    private String Correo_Electronico;
    private String Direccion;
    private String DNI;

    public Clientes() {
    }

    public Clientes(int idClientes, String Nombres_Apellidos, String Telefono, String Correo_Electronico, String Direccion, String DNI) {
        this.idClientes = idClientes;
        this.Nombres_Apellidos = Nombres_Apellidos;
        this.Telefono = Telefono;
        this.Correo_Electronico = Correo_Electronico;
        this.Direccion = Direccion;
        this.DNI = DNI;
    }

    public int getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombres_Apellidos() {
        return Nombres_Apellidos;
    }

    public void setNombres_Apellidos(String Nombres_Apellidos) {
        this.Nombres_Apellidos = Nombres_Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String Correo_Electronico) {
        this.Correo_Electronico = Correo_Electronico;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
 
}
