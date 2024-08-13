package Dao;

import Conexion.Conexion;
import Model.RespaldoM;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para la entidad Mascotas.
 */
public class MascotasDao extends Conexion {

    private Conexion c;

    public MascotasDao(Conexion conexion) {
        this.c = conexion;
    }

    public MascotasDao() {
    }

    public ArrayList<RespaldoM> listarMascotas() {
        ArrayList<RespaldoM> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT  \n"
                    + "    mas.idMascotas,\n"
                    + "    mas.Nombre,\n"
                    + "    mas.F_Nacimiento,\n"
                    + "    cli.Nombres AS Nombres,\n"
                    + "    ra.Descripcion AS Raza,\n"
                    + "    sex.Descripcion AS Sexo,\n"
                    + "    tda.Descripcion AS tipo_Animal\n"
                    + "FROM \n"
                    + "    mydb.mascotas mas\n"
                    + "    INNER JOIN mydb.clientes cli ON mas.Clientes_idClientes = cli.idClientes\n"
                    + "    INNER JOIN mydb.raza ra ON mas.idRaza = ra.idRaza\n"
                    + "    INNER JOIN mydb.sexo sex ON mas.idSexo = sex.idSexo\n"
                    + "    INNER JOIN mydb.tipo_de_animal tda ON mas.idTipo_De_Animal = tda.idTipo_De_Animal;";

            try (PreparedStatement pre = this.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()) {

                while (rs.next()) {
                    RespaldoM mascota = new RespaldoM();
                    mascota.setIdMascotas(rs.getInt(1));
                    mascota.setNombre(rs.getString(2));
                    mascota.setF_Nacimiento(rs.getDate(3).toLocalDate());
                    mascota.setNombres_Apellidos(rs.getString(4));
                    mascota.setDescripcion(rs.getString(5));
                    mascota.setSexo(rs.getString(6));
                    mascota.setTipo(rs.getString(7));
                    lista.add(mascota);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar mascotas: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int insertarMascota(RespaldoM m) {

        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO mydb.mascotas (Nombre, F_Nacimiento, Clientes_idClientes, idRaza, idSexo, idTipo_De_Animal) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setDate(2, Date.valueOf(m.getF_Nacimiento()));
            pre.setInt(2, m.getClientes_idClientes());
            pre.setInt(3, m.getIdRaza());
            pre.setInt(4, m.getIdSexo());
            pre.setInt(5, m.getidTipo_De_Animal());

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar mascota " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;

    }

    public int eliminarMascota(int idMascotas) {
        int res = 0;

        try {
            this.conectar();
            String sql = "DELETE FROM mascotas WHERE idMascotas=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, idMascotas);
            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar mascota " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;

    }

    public List<RespaldoM> listarMascotasPorCliente(int clienteId) {
        List<RespaldoM> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM mascotas WHERE Clientes_idClientes = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, clienteId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RespaldoM mascota = new RespaldoM();
                mascota.setIdMascotas(rs.getInt(1));
                mascota.setNombre(rs.getString(2));
                lista.add(mascota);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar mascotas dao: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
