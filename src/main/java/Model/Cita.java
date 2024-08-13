/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author josel
 */
public class Cita {
    
    private int idCita;
    private String Hora_Cita;
    private int Mascotas_idMascotas;
    private String Nombre ;
    private int  M_idClientes;
    private String Nombre_Apellidos;
    private int idUser ;
    private String Nombres_Apellidos;
    private int idEstado ;
    private String Estado_Cita; 
    private String Motivo ;

    public Cita() {
    }

    public Cita(int idCita, String Hora_Cita, int Mascotas_idMascotas, int M_idClientes, int idUser, int idEstado, String Motivo) {
        this.idCita = idCita;
        this.Hora_Cita = Hora_Cita;
        this.Mascotas_idMascotas = Mascotas_idMascotas;
        this.M_idClientes = M_idClientes;
        this.idUser = idUser;
        this.idEstado = idEstado;
        this.Motivo = Motivo;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getHora_Cita() {
        return Hora_Cita;
    }

    public void setHora_Cita(String Hora_Cita) {
        this.Hora_Cita = Hora_Cita;
    }

    public int getMascotas_idMascotas() {
        return Mascotas_idMascotas;
    }

    public void setMascotas_idMascotas(int Mascotas_idMascotas) {
        this.Mascotas_idMascotas = Mascotas_idMascotas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getM_idClientes() {
        return M_idClientes;
    }

    public void setM_idClientes(int M_idClientes) {
        this.M_idClientes = M_idClientes;
    }

    public String getNombre_Apellidos() {
        return Nombre_Apellidos;
    }

    public void setNombre_Apellidos(String Nombre_Apellidos) {
        this.Nombre_Apellidos = Nombre_Apellidos;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombres_Apellidos() {
        return Nombres_Apellidos;
    }

    public void setNombres_Apellidos(String Nombres_Apellidos) {
        this.Nombres_Apellidos = Nombres_Apellidos;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado_Cita() {
        return Estado_Cita;
    }

    public void setEstado_Cita(String Estado_Cita) {
        this.Estado_Cita = Estado_Cita;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

  

 
 
    
    
}
