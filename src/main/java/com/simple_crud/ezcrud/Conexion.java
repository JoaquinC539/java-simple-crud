
package com.simple_crud.ezcrud;

import java.sql.*;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String pass = "labonita2012";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, pass);
    }

    public static void cerrar(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void cerrar(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void cerrar(Connection conn) throws SQLException {
        conn.close();
    }
}
