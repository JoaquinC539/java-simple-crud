package com.simple_crud.ezcrud;

import java.sql.SQLException;

public class Controllets {
    public String newMessage(String message, String author) throws ClassNotFoundException, SQLException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje msm = new Mensaje(message, author);
        int registro = mensajeDAO.insertar(msm);
        String msg = ("Se inserto " + registro + " registro");
        return msg;
    }

    public static String getData() {
        return null;
    }
}
