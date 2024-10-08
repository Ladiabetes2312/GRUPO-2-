/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author josel
 */
public class R_Atencion {
    private int idRegistro;
    private String hora;
    private Date fechaVisita;
    private String motivoVisita;
    private String estadoMascota;
    private String diagnosticoGenerado;
    private String tratamiento;
    private String observaciones;
    private int citasIdCitas;
    private String NombreM;

    // Constructor vacío
    public R_Atencion() {
    }

    public R_Atencion(int idRegistro, String hora, Date fechaVisita, String motivoVisita, String estadoMascota, String diagnosticoGenerado, String tratamiento, String observaciones, int citasIdCitas, String NombreM) {
        this.idRegistro = idRegistro;
        this.hora = hora;
        this.fechaVisita = fechaVisita;
        this.motivoVisita = motivoVisita;
        this.estadoMascota = estadoMascota;
        this.diagnosticoGenerado = diagnosticoGenerado;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.citasIdCitas = citasIdCitas;
        this.NombreM = NombreM;
    }

    public R_Atencion(int idRegistro, String hora, Date fechaVisita, String motivoVisita, String estadoMascota, String diagnosticoGenerado, String tratamiento, String observaciones, int citasIdCitas) {
        this.idRegistro = idRegistro;
        this.hora = hora;
        this.fechaVisita = fechaVisita;
        this.motivoVisita = motivoVisita;
        this.estadoMascota = estadoMascota;
        this.diagnosticoGenerado = diagnosticoGenerado;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.citasIdCitas = citasIdCitas;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public String getEstadoMascota() {
        return estadoMascota;
    }

    public void setEstadoMascota(String estadoMascota) {
        this.estadoMascota = estadoMascota;
    }

    public String getDiagnosticoGenerado() {
        return diagnosticoGenerado;
    }

    public void setDiagnosticoGenerado(String diagnosticoGenerado) {
        this.diagnosticoGenerado = diagnosticoGenerado;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getCitasIdCitas() {
        return citasIdCitas;
    }

    public void setCitasIdCitas(int citasIdCitas) {
        this.citasIdCitas = citasIdCitas;
    }

    public String getNombreM() {
        return NombreM;
    }

    public void setNombreM(String NombreM) {
        this.NombreM = NombreM;
    }




}
