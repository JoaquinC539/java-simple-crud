package com.simple_crud.ezcrud;

import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controllets {
    @PostMapping("/message")
    public String add(@RequestParam String message, @RequestParam String author)
            throws SQLException, ClassNotFoundException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje msm = new Mensaje(message, author);
        int registro = mensajeDAO.insertar(msm);
        String msg = ("Se inserto " + registro + " registro");
        return msg;
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<Mensaje> selectOne(@PathVariable("id") int id) throws ClassNotFoundException, SQLException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje mensaje = new Mensaje(id);
        Optional<Mensaje> optionalMensaje = mensajeDAO.seleccionarUno(mensaje);
        if (optionalMensaje.isPresent()) {
            return ResponseEntity.ok(optionalMensaje.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/message")
    public List<Mensaje> select() throws ClassNotFoundException, SQLException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        List<Mensaje> data = mensajeDAO.seleccionar();
        return data;
    }

    @PutMapping("/message")
    public int edit(@RequestParam int id, @RequestParam String message, @RequestParam String author)
            throws SQLException, ClassNotFoundException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje msm = new Mensaje(id, message, author);
        int registry = mensajeDAO.editar(msm);
        return registry;
    }

    @DeleteMapping("/message")
    public int delete(@RequestParam int id) throws ClassNotFoundException, SQLException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje deleteId = new Mensaje(id);
        int registry = mensajeDAO.eliminar(deleteId);
        return registry;
    }
}
