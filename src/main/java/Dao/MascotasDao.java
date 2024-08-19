package Dao;

import Conexion.Conexion;
import Model.Mascotas;
import java.sql.Date;
import java.time.LocalDate;
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

    public ArrayList<Mascotas> listarMascotas() {
        ArrayList<Mascotas> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT  \n"
                    + "    mas.idMascotas,\n"
                    + "    mas.NombreM,\n"
                    + "    mas.F_Nacimiento,\n"
                    + "    cli.Nombres AS Nombres,\n"
                    + "    ra.Raza AS Raza,\n"
                    + "    sex.Sexo AS Sexo,\n"
                    + "    tda.Tipo AS tipo_Animal\n"
                    + "FROM \n"
                    + "    mydb.mascotas mas\n"
                    + "    INNER JOIN mydb.clientes cli ON mas.Clientes_idClientes = cli.idClientes\n"
                    + "    INNER JOIN mydb.raza ra ON mas.idRaza = ra.idRaza\n"
                    + "    INNER JOIN mydb.sexo sex ON mas.idSexo = sex.idSexo\n"
                    + "    INNER JOIN mydb.tipo_de_animal tda ON mas.idTipo_De_Animal = tda.idTipo_De_Animal;";

            try (PreparedStatement pre = this.getCon().prepareStatement(sql); ResultSet rs = pre.executeQuery()) {

                while (rs.next()) {
                    Mascotas mascota = new Mascotas();
                    mascota.setIdMascotas(rs.getInt(1));
                    mascota.setNombreM(rs.getString(2));
                    mascota.setF_Nacimiento(rs.getDate(3).toLocalDate());
                    mascota.setNombres(rs.getString(4));
                    mascota.setRaza(rs.getString(5));
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

    public int insertarMascota(Mascotas m) {

        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO mascotas (NombreM, F_Nacimiento, Clientes_idClientes, idRaza, idSexo, idTipo_De_Animal) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, m.getNombreM());
            pre.setDate(2, java.sql.Date.valueOf(m.getF_Nacimiento()));
            pre.setInt(3, m.getClientes_idClientes());
            pre.setInt(4, m.getIdRaza());
            pre.setInt(5, m.getIdSexo());
            pre.setInt(6, m.getIdTipo_De_Animal());

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al insertar mascota " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;

    }

    public int modificarMascota(Mascotas ms) {
        int res = 0;

        try {
            this.conectar();
            String sql = "UPDATE mascotas SET NombreM=?, F_Nacimiento=?, Clientes_idClientes=?, idRaza=?, idSexo=?, idTipo_De_Animal=? WHERE idMascotas=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);

            pre.setString(1, ms.getNombreM());
            pre.setDate(2, Date.valueOf(ms.getF_Nacimiento()));
            pre.setInt(3, ms.getClientes_idClientes());
            pre.setInt(4, ms.getIdRaza());
            pre.setInt(5, ms.getIdSexo());
            pre.setInt(6, ms.getIdTipo_De_Animal());
            pre.setInt(7, ms.getIdMascotas());

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al Modificar" + e.getMessage());
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

    public List<Mascotas> listarMascotasPorCliente(int clienteId) {
        List<Mascotas> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM mascotas WHERE Clientes_idClientes = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, clienteId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mascotas mascota = new Mascotas();
                mascota.setIdMascotas(rs.getInt(1));
                mascota.setNombreM(rs.getString(2));
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
