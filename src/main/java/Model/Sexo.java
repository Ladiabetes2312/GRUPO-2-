/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package Model;
 
/**
*
* @author JOSUEDAVID
*/
public class Sexo {
    private int idSexo;
    private String Sexo;
 
    public Sexo() {
    }

    public Sexo(int idSexo, String Sexo) {
        this.idSexo = idSexo;
        this.Sexo = Sexo;
    }

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
}
