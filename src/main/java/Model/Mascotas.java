package Model;

import java.time.LocalDate;

/**
 *
 * @author josel
 */
public class Mascotas {

    private int idMascotas;
    private String NombreM;
    private LocalDate F_Nacimiento;
    private int Clientes_idClientes;
    private String Nombres;
    private int idRaza;
    private String Raza;
    private int idSexo;
    private String Sexo;
    private int idTipo_De_Animal;
    private String Tipo;

    public Mascotas() {
    }

    public Mascotas(int idMascotas, String NombreM, LocalDate F_Nacimiento, int Clientes_idClientes, String Nombres, int idRaza, String Raza, int idSexo, String Sexo, int idTipo_De_Animal, String Tipo) {
        this.idMascotas = idMascotas;
        this.NombreM = NombreM;
        this.F_Nacimiento = F_Nacimiento;
        this.Clientes_idClientes = Clientes_idClientes;
        this.Nombres = Nombres;
        this.idRaza = idRaza;
        this.Raza = Raza;
        this.idSexo = idSexo;
        this.Sexo = Sexo;
        this.idTipo_De_Animal = idTipo_De_Animal;
        this.Tipo = Tipo;
    }

    public Mascotas(int idMascotas, String NombreM, LocalDate F_Nacimiento, int Clientes_idClientes, int idRaza, int idSexo, int idTipo_De_Animal) {
        this.idMascotas = idMascotas;
        this.NombreM = NombreM;
        this.F_Nacimiento = F_Nacimiento;
        this.Clientes_idClientes = Clientes_idClientes;
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

    public String getNombreM() {
        return NombreM;
    }

    public void setNombreM(String NombreM) {
        this.NombreM = NombreM;
    }

    public LocalDate getF_Nacimiento() {
        return F_Nacimiento;
    }

    public void setF_Nacimiento(LocalDate F_Nacimiento) {
        this.F_Nacimiento = F_Nacimiento;
    }

    public int getClientes_idClientes() {
        return Clientes_idClientes;
    }

    public void setClientes_idClientes(int Clientes_idClientes) {
        this.Clientes_idClientes = Clientes_idClientes;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
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

    public int getIdTipo_De_Animal() {
        return idTipo_De_Animal;
    }

    public void setIdTipo_De_Animal(int idTipo_De_Animal) {
        this.idTipo_De_Animal = idTipo_De_Animal;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}
