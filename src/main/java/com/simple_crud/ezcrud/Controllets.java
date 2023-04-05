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
    public ResponseEntity<String> add(@RequestParam String message, @RequestParam String author)
            throws SQLException, ClassNotFoundException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje msm = new Mensaje(message, author);
        int registro = mensajeDAO.insertar(msm);
        String msg = ("Se inserto " + registro + " registro");
        return ResponseEntity.ok(msg);
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
    public ResponseEntity<List<Mensaje>> select() throws ClassNotFoundException, SQLException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        List<Mensaje> data = mensajeDAO.seleccionar();
        return ResponseEntity.ok(data);
    }

    @PutMapping("/message")
    public ResponseEntity<Integer> edit(@RequestParam int id, @RequestParam String message, @RequestParam String author)
            throws SQLException, ClassNotFoundException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje msm = new Mensaje(id, message, author);
        Integer registry = mensajeDAO.editar(msm);
        return ResponseEntity.ok(registry);

    }

    @DeleteMapping("/message")
    public ResponseEntity<Integer> delete(@RequestParam int id) throws ClassNotFoundException, SQLException {
        MensajeDAO mensajeDAO = new MensajeDAO();
        Mensaje deleteId = new Mensaje(id);
        Integer registry = mensajeDAO.eliminar(deleteId);
        return ResponseEntity.ok(registry);
    }
}
