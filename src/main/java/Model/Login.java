/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josel
 * 
 */
public class Login {
    
    private int idUsuarios;
    private String Nombres_Apellidos;
    private String Correo_Electronico;
    private String Usuario;
    private String Password;

    public Login() {
    }

    public Login(int idUsuarios, String Nombres_Apellidos, String Correo_Electronico, String Usuario, String Password) {
        this.idUsuarios = idUsuarios;
        this.Nombres_Apellidos = Nombres_Apellidos;
        this.Correo_Electronico = Correo_Electronico;
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombres_Apellidos() {
        return Nombres_Apellidos;
    }

    public void setNombres_Apellidos(String Nombres_Apellidos) {
        this.Nombres_Apellidos = Nombres_Apellidos;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public void setCorreo_Electronico(String Correo_Electronico) {
        this.Correo_Electronico = Correo_Electronico;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
