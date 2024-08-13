/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author josel
 */
public class EstadoCita {
    
    
    
    private int idEstado_Cita;
    private String Estado_Cita; 

    public EstadoCita() {
    }

    
    
    public EstadoCita(int idEstado_Cita, String Estado_Cita) {
        this.idEstado_Cita = idEstado_Cita;
        this.Estado_Cita = Estado_Cita;
    }

    public int getIdEstado_Cita() {
        return idEstado_Cita;
    }

    public void setIdEstado_Cita(int idEstado_Cita) {
        this.idEstado_Cita = idEstado_Cita;
    }

    public String getEstado_Cita() {
        return Estado_Cita;
    }

    public void setEstado_Cita(String Estado_Cita) {
        this.Estado_Cita = Estado_Cita;
    }
    
    
    
}
