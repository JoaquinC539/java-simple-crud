package com.simple_crud.ezcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@RestController
public class EzcrudApplication {
	@PostMapping("/api/new")
	public String add(@RequestParam String message, @RequestParam String author)
			throws SQLException, ClassNotFoundException {
		MensajeDAO mensajeDAO = new MensajeDAO();
		Mensaje msm = new Mensaje(message, author);
		int registro = mensajeDAO.insertar(msm);
		String msg = ("Se inserto " + registro + " registro");
		return msg;
	}

	@GetMapping("api/selectAll")
	public List<Mensaje> select() throws ClassNotFoundException, SQLException {
		MensajeDAO mensajeDAO = new MensajeDAO();
		List<Mensaje> data = mensajeDAO.seleccionar();
		return data;
	}

	@PutMapping("/api/edit")
	public int edit(@RequestParam int id, @RequestParam String message, @RequestParam String author)
			throws SQLException, ClassNotFoundException {
		MensajeDAO mensajeDAO = new MensajeDAO();
		Mensaje msm = new Mensaje(id, message, author);
		int registry = mensajeDAO.editar(msm);
		return registry;
	}

	@DeleteMapping("/api/delete")
	public int delete(@RequestParam int id) throws ClassNotFoundException, SQLException {
		MensajeDAO mensajeDAO = new MensajeDAO();
		Mensaje deleteId = new Mensaje(id);
		int registry = mensajeDAO.eliminar(deleteId);
		return registry;
	}

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	public static void main(String[] args) {
		SpringApplication.run(EzcrudApplication.class, args);
	}
}
