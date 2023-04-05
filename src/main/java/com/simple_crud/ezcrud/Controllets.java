package com.simple_crud.ezcrud;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controllets {
    @PostMapping("/new")
    public String add(@RequestParam String message, @RequestParam String author)
            throws SQLException, ClassNotFoundException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje msm = new Mensaje(message, author);
        int registro = mensajeDAO.insertar(msm);
        String msg = ("Se inserto " + registro + " registro");
        return msg;
    }

    @GetMapping("/selectAll")
    public List<Mensaje> select() throws ClassNotFoundException, SQLException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        List<Mensaje> data = mensajeDAO.seleccionar();
        return data;
    }

    @PutMapping("/edit")
    public int edit(@RequestParam int id, @RequestParam String message, @RequestParam String author)
            throws SQLException, ClassNotFoundException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje msm = new Mensaje(id, message, author);
        int registry = mensajeDAO.editar(msm);
        return registry;
    }

    @DeleteMapping("/delete")
    public int delete(@RequestParam int id) throws ClassNotFoundException, SQLException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje deleteId = new Mensaje(id);
        int registry = mensajeDAO.eliminar(deleteId);
        return registry;
    }
}
