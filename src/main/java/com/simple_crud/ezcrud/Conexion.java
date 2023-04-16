
package com.simple_crud.ezcrud;

import java.sql.*;

import io.github.cdimascio.dotenv.Dotenv;

public class Conexion {

    static Dotenv dotenv = Dotenv.load();

    private static final String URL = dotenv.get("DB_URL");
    private static final String USER = dotenv.get("DB_USER");
    private static final String PASS = dotenv.get("DB_PASS");

    ;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

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
