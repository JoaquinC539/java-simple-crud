
package com.simple_crud.ezcrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.simple_crud.ezcrud.Conexion.*;

public class MensajeDAO {
    private Connection con = null;
    private PreparedStatement PS = null;
    private ResultSet RS = null;
    private Mensaje mensaje;

    public List<Mensaje> seleccionar() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM mensajes";
        List<Mensaje> mensajes = new ArrayList<>();
        try {
            this.con = getConnection();
            this.PS = this.con.prepareStatement(sql);
            this.RS = this.PS.executeQuery();

            while (this.RS.next()) {
                int id = this.RS.getInt("id_mensaje");
                String msm = this.RS.getString("mensaje");
                String autor = this.RS.getString("autor");
                String fecha = this.RS.getString("fecha");

                this.mensaje = new Mensaje(id, msm, autor, fecha);
                mensajes.add(mensaje);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.PS);
                cerrar(this.RS);
                cerrar(this.con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return mensajes;
    }

    public int insertar(Mensaje mensaje) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO mensajes(mensaje,autor,fecha) VALUES (?,?,CURRENT_TIME())";
        List<Mensaje> mensajes = new ArrayList<>();
        int registros = 0;
        try {
            this.con = getConnection();
            this.PS = this.con.prepareStatement(sql);
            this.PS.setString(1, mensaje.getMensaje());
            this.PS.setString(2, mensaje.getAutor());
            registros = this.PS.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.PS);
                cerrar(this.con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int editar(Mensaje mensaje) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE mensajes SET mensaje=?,autor=? WHERE id_mensaje=?";
        int registros = 0;
        try {
            this.con = getConnection();
            this.PS = this.con.prepareStatement(sql);
            this.PS.setString(1, mensaje.getMensaje());
            this.PS.setString(2, mensaje.getAutor());
            this.PS.setInt(3, mensaje.getId());
            registros = this.PS.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.PS);
                cerrar(this.con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int eliminar(Mensaje mensaje) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM mensajes WHERE id_mensaje=?";
        int registros = 0;
        try {
            this.con = getConnection();
            this.PS = this.con.prepareStatement(sql);
            this.PS.setInt(1, mensaje.getId());
            registros = this.PS.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.PS);
                cerrar(this.con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

}
